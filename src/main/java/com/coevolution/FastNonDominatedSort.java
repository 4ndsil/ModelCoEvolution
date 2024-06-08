package com.coevolution;

import java.security.DrbgParameters.Instantiation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.namespace.QName;

public class FastNonDominatedSort {
    private Model model;

    public FastNonDominatedSort(Model model) {
        this.model = model;
    }

    public void assignCrowdingDistance(List<CandidateSolution> solutions) {
        for (CandidateSolution solution : solutions) {
            solution.setCrowdingDistance(0.0);
        }

        for (int m = 0; m < 3; m++) {
            final int finalM = m;
            
            Collections.sort(solutions, (a, b) -> Double.compare(a.getNormalizedFitnessPerObjective(finalM),
                    b.getNormalizedFitnessPerObjective(finalM)));
            
            solutions.get(0).setCrowdingDistance(Double.POSITIVE_INFINITY);
            solutions.get(solutions.size() - 1).setCrowdingDistance(Double.POSITIVE_INFINITY);
            
            for (int i = 1; i < solutions.size() - 1; i++) {
                double distance = solutions.get(i).getCrowdingDistance();
                distance += solutions.get(i + 1).getNormalizedFitnessPerObjective(finalM) - solutions.get(i - 1)
                        .getNormalizedFitnessPerObjective(finalM);
                solutions.get(i).setCrowdingDistance(distance);
            }
        }
    }


    public List<Front> fastNonDominatedSort(List<CandidateSolution> candidateSolutions, Model metamodel, Model model) {
        List<Front> fronts = new ArrayList<>();        
        int frontLevel = 1;
        setAllUnassigned(candidateSolutions);
        while (true) {
            List<CandidateSolution> remainingSolutions = getUnassignedSolutions(candidateSolutions);
            if (remainingSolutions.isEmpty()) {
                break;
            }
            Front currentFront = new Front(frontLevel);
            List<CandidateSolution> solutionsToRemove = new ArrayList<>();
            
            for (CandidateSolution p : remainingSolutions) {
                boolean isDominated = false;                
                for (CandidateSolution q : remainingSolutions) {
                    if (p != q && dominates(metamodel, model, q, p) && !p.getIsAssigned() && !q.getIsAssigned()) {
                        isDominated = true;
                        break;
                    }
                }

                if (!isDominated && !p.getIsAssigned()) {
                    p.setIsAssigned(true);
                    currentFront.solutions.add(p);
                    p.setIsAssigned(true);
                    solutionsToRemove.add(p);
                }
            }

            remainingSolutions.removeAll(solutionsToRemove);

            if (currentFront.solutions.size() > 0) {
                fronts.add(currentFront);
                frontLevel++;
            }
        }
        return fronts;
    }

    private boolean dominates(Model metamodel, Model model, CandidateSolution q, CandidateSolution p) {
        return p.getNormalizedFitness() > q.getNormalizedFitness();
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
