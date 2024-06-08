package com.coevolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class PopulationSelector {
    private Random random;
    private Integer POPULATION_SIZE;
    private List<EditOperation<Class>> edits;
    private static final double MUTATION_PROBABILITY = 0.7;
    private static final double CROSSOVER_PROBABILITY = 0.8;

    public PopulationSelector(List<EditOperation<Class>> edits) {
        this.random = new Random();
        this.edits = edits;
        this.POPULATION_SIZE = 100;
    }

    public List<CandidateSolution> initializePopulation(Model metamodel, Model model) {        

        List<CandidateSolution> candidateSolutions = new ArrayList<>();  

        while (candidateSolutions.size() < POPULATION_SIZE) {
            CandidateSolution solution = new CandidateSolution();
            for (int i = 0; i < (random.nextInt(30) + 8); i++) {
                int rand = random.nextInt(edits.size());
                EditOperation op = edits.get(rand);
                solution.addEditOperation(op);
            }
            solution.setFitnessValues(metamodel, model);

            candidateSolutions.add(solution);
        }

        return candidateSolutions;
    }

    public List<CandidateSolution> initializeOffspring(List<CandidateSolution> candidateSolutions, Model metamodel, Model model) {
        List<CandidateSolution> offspring = new ArrayList<>();  
        while (offspring.size() < POPULATION_SIZE / 2) {
            CandidateSolution parent1 = selectParent(candidateSolutions);
            CandidateSolution parent2 = selectParent(candidateSolutions);

            crossover(parent1, parent2);

            mutateSolution(candidateSolutions, metamodel, model, parent1);
            mutateSolution(candidateSolutions,  metamodel, model, parent2);
            offspring.add(parent1);
            offspring.add(parent2);
        }
        return offspring;
    }

    public CandidateSolution getParentSolution(List<CandidateSolution> candidateSolutions) {
        return selectParent(candidateSolutions);
    }

    private CandidateSolution selectParent(List<CandidateSolution> candidateSolutions) {
        int tournamentSize = 2;

        List<CandidateSolution> tournamentParticipants = new ArrayList<>();
        for (int i = 0; i < tournamentSize; i++) {
            int rand = random.nextInt(candidateSolutions.size());
            CandidateSolution randSolution = candidateSolutions.get(rand);
            tournamentParticipants.add(randSolution);
        }

        CandidateSolution bestSolution = null;
        for (CandidateSolution participant : tournamentParticipants) {
            if (bestSolution == null || participant
                    .getNormalizedFitness() > bestSolution.getNormalizedFitness()) {
                bestSolution = participant;
            }
        }

        return bestSolution;
    }

    public void crossover(CandidateSolution parent1, CandidateSolution parent2) {
        onePointCrossover(parent1, parent2);
    }

    private void onePointCrossover(CandidateSolution parent1, CandidateSolution parent2) {
        if (random.nextDouble() < CROSSOVER_PROBABILITY) {
            int size1 = parent1.getEditOperations().size();
            int size2 = parent2.getEditOperations().size();

            int crossoverPoint = random.nextInt(Math.min(size1, size2) + 1);

            List<EditOperation> child1perations = new ArrayList<>(
                    parent1.getEditOperations().subList(0, crossoverPoint));
            child1perations.addAll(parent2.getEditOperations().subList(crossoverPoint, size2));

            List<EditOperation> child2perations = new ArrayList<>(
                    parent2.getEditOperations().subList(0, crossoverPoint));
            child2perations.addAll(parent1.getEditOperations().subList(crossoverPoint, size1));

            parent1.setEditOperation(child1perations);
            parent2.setEditOperation(child2perations);
        }
    }

    public void mutateSolution(List<CandidateSolution> candidateSolutions, Model metamodel, Model model, CandidateSolution solution) {
        mutate(candidateSolutions, metamodel, model, solution);
    }

    private void mutate(List<CandidateSolution> candidateSolutions, Model metamodel, Model model, CandidateSolution solution) {
        if (random.nextDouble() < MUTATION_PROBABILITY) {
            int numMutations = random.nextInt(2) + 1; // select 1 or 2 mutations

            for (int i = 0; i < numMutations; i++) {
                int indexToMutate = random.nextInt(solution.size());

                int mutationType = random.nextInt(2);
                if (mutationType == 0) {
                    int newIndex = random.nextInt(solution.size());
                    EditOperation temp = solution.getEditOperations().get(indexToMutate);
                    solution.getEditOperations().set(indexToMutate,
                            solution.getEditOperations().get(newIndex));
                    solution.getEditOperations().set(newIndex, temp);
                } else {
                    int randomIndex = random.nextInt(edits.size());
                    EditOperation newOperation = edits.get(randomIndex);
                    if (!solution.getEditOperations().contains(newOperation)) {
                        solution.getEditOperations().set(indexToMutate, newOperation);
                    }
                }
            }
            List<EditOperation> operations = solution.getEditOperations();
            Set<EditOperation> seenOperations = new HashSet<>();

            Iterator<EditOperation> iterator = operations.iterator();
            while (iterator.hasNext()) {
                EditOperation operation = iterator.next();
                if (seenOperations.contains(operation)) {
                    iterator.remove();
                } else {
                    seenOperations.add(operation);
                }
            }            
        }
    }

    public double findMinNvc(List<CandidateSolution> solutions) {
        return solutions.stream().mapToDouble(CandidateSolution::getNvc).min().orElse(Double.MAX_VALUE);
    }

    public double findMinNbOp(List<CandidateSolution> solutions) {
        return solutions.stream().mapToDouble(CandidateSolution::getNbOp).min().orElse(Double.MAX_VALUE);
    }

    public double findMinInconsistency(List<CandidateSolution> solutions) {
        return solutions.stream().mapToDouble(CandidateSolution::getInconsistency).min().orElse(Double.MAX_VALUE);
    }

    public double findMaxNvc(List<CandidateSolution> solutions) {
        return solutions.stream().mapToDouble(CandidateSolution::getNvc).max().orElse(0.0);
    }

    public double findMaxNbOp(List<CandidateSolution> solutions) {
        return solutions.stream().mapToDouble(CandidateSolution::getNbOp).max().orElse(0.0);
    }

    public double findMaxInconsistency(List<CandidateSolution> solutions) {
        return solutions.stream().mapToDouble(CandidateSolution::getInconsistency).max().orElse(0.0);
    }
}