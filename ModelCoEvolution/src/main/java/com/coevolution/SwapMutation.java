package com.coevolution;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.util.errorchecking.JMetalException;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;

public class SwapMutation implements MutationOperator<CandidateSolution> {
    private double mutationProbability;
    private final Random random;
    private final List<RepairOperation> repairOperations;

    public SwapMutation(double mutationProbability, List<RepairOperation> repairOperations) {
        if (mutationProbability < 0) {
            throw new JMetalException("Mutation probability is negative: " + mutationProbability);
        }
        this.repairOperations = repairOperations;
        this.mutationProbability = mutationProbability;
        this.random = new Random();
    }

    @Override
    public CandidateSolution execute(CandidateSolution solution) {
        if (solution == null) {
            throw new JMetalException("Null parameter");
        }
        doMutation(mutationProbability, solution);

        return solution;
    }

    private void doMutation(double probability, CandidateSolution solution) {
        JMetalRandom jRandom = JMetalRandom.getInstance();

        if (jRandom.nextDouble() <= probability) {
            int numMutations = random.nextInt(2) + 1;

            for (int i = 0; i < numMutations; i++) {
                int indexToMutate = random.nextInt(solution.getRepairOperations().size());

                int mutationType = random.nextInt(2);
                if (mutationType == 0) {
                    int newIndex = random.nextInt(solution.getRepairOperations().size());
                    Collections.swap(solution.getRepairOperations(), indexToMutate, newIndex);
                } else {
                    int randomIndex = random.nextInt(repairOperations.size());
                    RepairOperation newOperation = repairOperations.get(randomIndex);
                    if (!solution.getRepairOperations().contains(newOperation)) {
                        solution.getRepairOperations().set(indexToMutate, newOperation);
                    }
                }
            }

            removeDuplicateOperations(solution);
        }
    }

     private void removeDuplicateOperations(CandidateSolution solution) {
        List<RepairOperation> operations = solution.getRepairOperations();
        Set<RepairOperation> seenOperations = new HashSet<>();

        Iterator<RepairOperation> iterator = operations.iterator();
        while (iterator.hasNext()) {
            RepairOperation operation = iterator.next();
            if (seenOperations.contains(operation)) {
                iterator.remove();
            } else {
                seenOperations.add(operation);
            }
        }
    }

    @Override
    public double getMutationProbability() {
        throw new UnsupportedOperationException("Unimplemented method 'getMutationProbability'");
    }
}