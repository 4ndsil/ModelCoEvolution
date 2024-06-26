package com.coevolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class NSGAII {

    private static final double STOPPING_CRITERIA = 250;
    
    private final Model metamodel;
    private final Model model;
    private final PopulationSelector populationSelector;
    private final NonDominantSort nds;
    private final ExecutorService executorService;
    private final double sharingRadius = 0.5;
    private final double alpha = 1.0;

    public NSGAII(Model metamodel, Model model, List<EditOperation<Class>> edits) {        
        this.metamodel = metamodel;
        this.model = model;
        this.populationSelector = new PopulationSelector(edits);
        this.nds = new NonDominantSort();
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

       public List<CandidateSolution> runNSGAII() {
        List<CandidateSolution> P = populationSelector.initializePopulation(metamodel, model);
        List<CandidateSolution> Q = populationSelector.initializeOffspring(P, metamodel, model);     
        for (int generation = 0; generation < STOPPING_CRITERIA; generation++) {
            List<CandidateSolution> R = new ArrayList<>();
            R.addAll(P);
            R.addAll(Q);

            setFitnessParallel(R);
            applyFitnessSharing(R);

            List<List<CandidateSolution>> fronts = nds.nonDominantSort(R);

            List<CandidateSolution> P1 = new ArrayList<>();
            int i = 0;

            while (P1.size() + fronts.get(i).size() <= Q.size()) {
                List<CandidateSolution> currentFront = fronts.get(i);
                nds.assignCrowdingDistance(currentFront);
                P1.addAll(currentFront);
                i++;
                if (i == fronts.size() - 1) break;
            }

            if (P1.size() < Q.size()) {
                List<CandidateSolution> lastFront = fronts.get(i);
                nds.assignCrowdingDistance(lastFront);
                Collections.sort(lastFront, this::compareByCrowdingDistance);

                int elementsToAdd = Math.min(Q.size() - P1.size(), lastFront.size());
                for (int j = 0; j < elementsToAdd; j++) {
                    P1.add(lastFront.get(j));
                }
            }

            List<CandidateSolution> Q1 = new ArrayList<>();
            while (Q1.size() < Q.size()) {
                CandidateSolution parent1 = populationSelector.getParentSolution(P1);
                CandidateSolution parent2 = populationSelector.getParentSolution(P1);

                populationSelector.crossover(parent1, parent2);              

                populationSelector.mutateSolution(parent1);
                populationSelector.mutateSolution(parent2);

                Q1.add(parent1);        
                if (Q1.size() < Q.size()) {
                    Q1.add(parent2);
                }
            }

            System.out.println("Generation: " + generation);
            P = P1;
            Q = Q1;
        }

        executorService.shutdown();
        return P;
    }

       private void setFitnessParallel(List<CandidateSolution> solutions) {
        try {
            List<Future<Void>> futures = new ArrayList<>();
            for (CandidateSolution solution : solutions) {
                futures.add(executorService.submit(() -> {
                    solution.setFitnessValues();
                    return null;
                }));
            }
            for (Future<Void> future : futures) {
                future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        applyFitnessSharing(solutions);
    }

    private void applyFitnessSharing(List<CandidateSolution> solutions) {
        for (CandidateSolution p : solutions) {
            double sharedFitness = p.getTotalFitness();
            for (CandidateSolution q : solutions) {
                if (p != q) {
                    double distance = distance(p, q);
                    sharedFitness += sharingFunction(distance);
                }
            }
            p.setSharedFitness(sharedFitness);
        }
    }

    private double distance(CandidateSolution sol1, CandidateSolution sol2) {
        double distance = 0.0;
        for (int j = 1; j < 3; j++) {
            distance += Math.abs(sol1.getFitnessValue(j) - sol2.getFitnessValue(j));
        }
        return Math.sqrt(distance);
    }

    private double sharingFunction(double distance) {
        if (distance < sharingRadius) {
            return 1 - Math.pow(distance / sharingRadius, alpha);
        }
        return 0;
    }

    private int compareByCrowdingDistance(CandidateSolution a, CandidateSolution b) {
        return Double.compare(b.getCrowdingDistance(), a.getCrowdingDistance());
    }
}