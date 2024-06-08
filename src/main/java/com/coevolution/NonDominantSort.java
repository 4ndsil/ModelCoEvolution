package com.coevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NonDominantSort {
    private Model model;

    public NonDominantSort(Model model) {
        this.model = model;
    }

    public void assignCrowdingDistance(List<CandidateSolution> solutions) {        

        for (int i = 0; i < 3; i++) {
            int objectiveIndex = i;
            solutions.sort((a, b) -> Double.compare(a.getNormalizedFitnessPerObjective(objectiveIndex), b.getNormalizedFitnessPerObjective(objectiveIndex)));

            solutions.get(0).setCrowdingDistance(Double.POSITIVE_INFINITY);
            solutions.get(solutions.size() - 1).setCrowdingDistance(Double.POSITIVE_INFINITY);

            double minObjectiveValue = solutions.get(0).getNormalizedFitnessPerObjective(objectiveIndex);
            double maxObjectiveValue = solutions.get(solutions.size() - 1).getNormalizedFitnessPerObjective(objectiveIndex);

            for (int j = 1; j < solutions.size() - 1; j++) {
                double distance = solutions.get(j).getCrowdingDistance();
                distance += (solutions.get(j + 1).getNormalizedFitnessPerObjective(objectiveIndex) - solutions.get(j - 1).getNormalizedFitnessPerObjective(objectiveIndex)) / (maxObjectiveValue - minObjectiveValue);
                solutions.get(j).setCrowdingDistance(distance);
            }
        }
    }

    public List<List<CandidateSolution>> nonDominantSort(List<CandidateSolution> candidateSolutions, Model metamodel, Model model) {
        List<List<CandidateSolution>> fronts = new ArrayList<>();
        List<CandidateSolution> firstFront = new ArrayList<>();
        fronts.add(firstFront);

        for (CandidateSolution p : candidateSolutions) {
            p.dominationCount = 0;
            p.dominatedSolutions = new ArrayList<>();

            for (CandidateSolution q : candidateSolutions) {
                if (dominates(p, q)) {
                    p.dominatedSolutions.add(q);
                } else if (dominates(q, p)) {
                    p.dominationCount++;
                }
            }

            if (p.dominationCount == 0) {
                firstFront.add(p);
            }
        }

        int i = 0;
        while (!fronts.get(i).isEmpty()) {
            List<CandidateSolution> nextFront = new ArrayList<>();
            for (CandidateSolution p : fronts.get(i)) {
                for (CandidateSolution q : p.dominatedSolutions) {
                    q.dominationCount--;
                    if (q.dominationCount == 0) {                        
                        nextFront.add(q);
                    }
                }
            }
            i++;
            fronts.add(nextFront);
        }
   
        if (fronts.get(fronts.size() - 1).isEmpty()) {
            fronts.remove(fronts.size() - 1);
        }

        return fronts;
    }

    private boolean dominates(CandidateSolution q, CandidateSolution p) {
        boolean betterInAtLeastOneObjective = true;
        
        for (int i = 0; i < 3; i++) {
            if (p.getNormalizedFitnessPerObjective(i) > q.getNormalizedFitnessPerObjective(i)) {
                return true; // p is worse in this objective
            }
            if (p.getNormalizedFitnessPerObjective(i) < q.getNormalizedFitnessPerObjective(i)) {
                betterInAtLeastOneObjective = false;
            }
        }
        
        return betterInAtLeastOneObjective;
    }

    private List<CandidateSolution> getUnassignedSolutions(List<CandidateSolution> candidateSolutions) {
        return candidateSolutions.stream()
                                 .filter(solution -> !solution.getIsAssigned())
                                 .collect(Collectors.toList());
    }

    private void setAllUnassigned(List<CandidateSolution> candidateSolutions) {
        for (CandidateSolution solution : candidateSolutions) {
            solution.setIsAssigned(false);
        }
    }
}
