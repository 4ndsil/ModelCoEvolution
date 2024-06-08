package com.coevolution;

import java.security.DrbgParameters.Instantiation;
import java.util.ArrayList;
import java.util.List;

public class CandidateSolution {
    private List<EditOperation> editOperations;
    private boolean isAssigned;
    private double crowdingDistance;
    private double currNvc;
    private double currNbOp;
    private double currInconsistency;
    private double minNvc;
    private double maxNvc;
    private double minNbOp;
    private double maxNbOp;
    private double minInconsistency;
    private double maxInconsistency;
    private double normalizedFitness;

    public int dominationCount;
    public List<CandidateSolution> dominatedSolutions;
    public final FitnessFunctions fitnessFunctions;

    public CandidateSolution() {
        editOperations = new ArrayList<>();
        fitnessFunctions = new FitnessFunctions();
        normalizedFitness = 0.0;
    }

    public CandidateSolution(List<EditOperation> editOperations) {
        this.editOperations = editOperations;
        fitnessFunctions = new FitnessFunctions();
        normalizedFitness = 0.0;
    }

    public boolean getIsAssigned(){
        return isAssigned;
    }

    public void setIsAssigned(boolean isAssigned){
        this.isAssigned = isAssigned;
    }

    public double getNvc() {
        return currNvc;
    }

    public double getNbOp() {
        return currNbOp;
    }

    public double getInconsistency() {
        return currInconsistency;
    }

    public double getMinNvc() {
        return minNvc;
    }

    public void setMinNvc(double val) {
        this.minNvc = val;
    }

    public double getMaxNvc() {
        return maxNvc;
    }

    public void setMaxNvc(double val) {
        this.maxNvc = val;
    }

    public double getMinNbOp() {
        return minNbOp;
    }

    public void setMinNbOp(double val) {
        this.minNbOp = val;
    }

    public double getMaxNbOp() {
        return maxNbOp;
    }

    public void setMaxNbOp(double val) {
        this.maxNbOp = val;
    }

    public double getMinInconsistency() {
        return minInconsistency;
    }

    public void setMinInconsistency(double val) {
        this.minInconsistency = val;
    }

    public double getMaxInconsistency() {
        return maxInconsistency;
    }

    public void setMaxInconsistency(double val) {
        this.maxInconsistency = val;
    }

    public void addEditOperation(EditOperation op) {
        editOperations.add(op);
    }

    public void setEditOperation(List<EditOperation> ops) {
        this.editOperations = null;
        this.editOperations = new ArrayList<>(ops);
    }

    public void removeEditOperation(EditOperation op) {
        editOperations.remove(op);
    }

    public List<EditOperation> getEditOperations() {
        return editOperations;
    }

    public int size() {
        return editOperations.size();
    }

    public EditOperation getOperation(int i) {
        return editOperations.get(i);
    }

    public EditOperation setOperation(int i, EditOperation operation) {
        return editOperations.set(i, operation);
    }

    public double getCrowdingDistance() {
        return crowdingDistance;
    }

    public void setCrowdingDistance(double crowdingDistance) {
        this.crowdingDistance = crowdingDistance;
    }

    public double getTotalFitness() {
        return currNvc + currNbOp + currInconsistency;
    }

    public double getFitnessValue(Instantiation metamodel, Instantiation model,
            int objective) {

        double objectiveValue = 0.0;
        if (objective == 0) {
            objectiveValue = currNvc;
        }
        if (objective == 1) {
            objectiveValue = currNbOp;
        }
        if (objective == 2) {
            objectiveValue = currInconsistency;
        }

        return objectiveValue;
    }

    public void setFitnessValue(Model metamodel, Model model, int objective) {
        SolutionProcessor processor = new SolutionProcessor();
        Model revModel = processor.runProcessSolution(model, CandidateSolution.this);
        if (objective == 0) {
            currNvc = this.fitnessFunctions.nvc(metamodel, revModel);
        }
        if (objective == 1) {
            currNbOp = this.fitnessFunctions.nbOp(CandidateSolution.this);
        }
        if (objective == 2) {
            currInconsistency = this.fitnessFunctions.inconsistency(model, revModel);
        }
    }

    public void setFitnessValues(Model metamodel, Model model) {
        SolutionProcessor processor = new SolutionProcessor();
        Model revModel = processor.runProcessSolution(model, CandidateSolution.this);
        currNvc = 0;
        currNvc = this.fitnessFunctions.nvc(metamodel, revModel);
        currNbOp = 0;
        currNbOp = this.fitnessFunctions.nbOp(CandidateSolution.this);
        currInconsistency = 0;
        currInconsistency = this.fitnessFunctions.inconsistency(model, revModel);
    }

    public double getNormalizedFitness() {
        return normalizedFitness;
    }

public double getNormalizedFitnessPerObjective(int i) {
    double normValue = 0.0;

    // Fetch minimum and maximum values for each objective
    double minNvc = getMinNvc();
    double maxNvc = getMaxNvc();
    double minNbOp = getMinNbOp();
    double maxNbOp = getMaxNbOp();
    double minInconsistency = getMinInconsistency();
    double maxInconsistency = getMaxInconsistency();

    if (i == 0) {
        normValue = (currNvc - minNvc) / (maxNvc - minNvc);
    } else if (i == 1) {
        normValue = (currNbOp - minNbOp) / (maxNbOp - minNbOp);
    } else if (i == 2) {
        normValue = (currInconsistency - minInconsistency) / (maxInconsistency - minInconsistency);
    }
    
    return normValue;
}

    public void setNormalizedFitness() {
         
        double minNvc = getMinNvc();
        double maxNvc = getMaxNvc();
        double minNbOp = getMinNbOp();
        double maxNbOp = getMaxNbOp();
        double minInconsistency = getMinInconsistency();
        double maxInconsistency = getMaxInconsistency();
        
        double normalizedNvc = (maxNvc == minNvc) ? 0.0 : (currNvc - minNvc) / (maxNvc - minNvc);    
        double normalizedNbOp = (maxNbOp == minNbOp) ? 0.0 : (currNbOp - minNbOp) / (maxNbOp - minNbOp);    
        double normalizedInconsistency = (maxInconsistency == minInconsistency) ? 0.0 : (currInconsistency - minInconsistency) / (maxInconsistency - minInconsistency);    


        this.normalizedFitness = (normalizedNvc + normalizedNbOp + normalizedInconsistency) / 3.0;    
    }
}

class Front {
    public List<CandidateSolution> solutions;
    public int frontLevel;

    public Front(List<CandidateSolution> solutions, int frontLevel) {
        this.solutions = solutions;
        this.frontLevel = frontLevel;
    }

    public Front(int frontLevel) {
        this.frontLevel = frontLevel;
        this.solutions = new ArrayList<CandidateSolution>();
    }
}