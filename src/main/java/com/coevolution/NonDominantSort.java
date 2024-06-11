package com.coevolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonDominantSort {

    public NonDominantSort() {

    }

    public void assignCrowdingDistance(List<CandidateSolution> solutions) {        

        for (int i = 0; i < 2; i++) {
            int objectiveIndex = i;
            solutions.sort((a, b) -> Double.compare(a.getFitnessValue(objectiveIndex), b.getFitnessValue(objectiveIndex)));

            solutions.get(0).setCrowdingDistance(Double.POSITIVE_INFINITY);
            solutions.get(solutions.size() - 1).setCrowdingDistance(Double.POSITIVE_INFINITY);

            double minObjectiveValue = solutions.get(0).getFitnessValue(objectiveIndex);
            double maxObjectiveValue = solutions.get(solutions.size() - 1).getFitnessValue(objectiveIndex);

            for (int j = 1; j < solutions.size() - 1; j++) {
                double distance = solutions.get(j).getCrowdingDistance();
                distance += (solutions.get(j + 1).getFitnessValue(objectiveIndex) - solutions.get(j - 1).getFitnessValue(objectiveIndex)) / (maxObjectiveValue - minObjectiveValue);
                solutions.get(j).setCrowdingDistance(distance);
            }
        }
    }

    public List<List<CandidateSolution>> nonDominantSort(List<CandidateSolution> candidateSolutions) {
        List<List<CandidateSolution>> fronts = new ArrayList<>();
        setAllUnassigned(candidateSolutions);
    
        while (true) {
            List<CandidateSolution> unAssigned = getUnassignedSolutions(candidateSolutions);
            if (unAssigned.isEmpty()) {
                break;
            }
    
            List<CandidateSolution> firstFront = new ArrayList<>();
            Map<CandidateSolution, List<CandidateSolution>> dominatedSolutions = new HashMap<>();
            Map<CandidateSolution, Integer> dominationCounts = new HashMap<>();
    
            for (CandidateSolution p : unAssigned) {
                dominatedSolutions.put(p, new ArrayList<>());
                dominationCounts.put(p, 0);
    
                for (CandidateSolution q : unAssigned) {
                    if (p != q) {
                        if (dominates(p, q) && !p.getIsAssigned() && !q.getIsAssigned()) {
                            dominatedSolutions.get(p).add(q);
                        } else if (dominates(q, p)) {
                            dominationCounts.put(p, dominationCounts.get(p) + 1);
                        }
                    }
                }
    
                if (dominationCounts.get(p) == 0 && !p.getIsAssigned()) {
                    firstFront.add(p);
                    p.setIsAssigned(true);
                }
            }
    
            fronts.add(firstFront);
            for (CandidateSolution p : firstFront) {
                calculateSharedFitness(p, firstFront);
            }
        }
    
        return fronts;
    }
    
    private void calculateSharedFitness(CandidateSolution solution, List<CandidateSolution> allSolutions) {
        double nicheRadius = 1.0;
        double sharedFitness = 0.0;
        
        for (CandidateSolution other : allSolutions) {
            double distance = calculateDistance(solution, other);
            if (distance < nicheRadius) {
                sharedFitness += 1 - (distance / nicheRadius);
            }
        }
        
        solution.setSharedFitness(sharedFitness);
    }
    
    private double calculateDistance(CandidateSolution p, CandidateSolution q) {
        double distance = 0.0;
        for (int i = 0; i < 2; i++) {
            distance += Math.pow(p.getFitnessValue(i) - q.getFitnessValue(i), 2);
        }
        return Math.sqrt(distance);
    }
    
    private boolean dominates(CandidateSolution q, CandidateSolution p) {
        boolean betterInAtLeastOneObjective = false;

        for (int i = 0; i < 3; i++) {
            if (q.getFitnessValue(i) > p.getFitnessValue(i)) {
                return false;
            }
            if (q.getFitnessValue(i) < p.getFitnessValue(i)) {
                betterInAtLeastOneObjective = true;
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