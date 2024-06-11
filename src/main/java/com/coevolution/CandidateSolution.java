package com.coevolution;

import java.util.ArrayList;
import java.util.List;

public class CandidateSolution {
    private List<EditOperation> editOperations;
    private Model model;
    private Model metamodel;
    private double sharedFitness;
    private boolean isAssigned;
    private double crowdingDistance;
    private double currNvc;
    private double currNbOp;
    private double currInconsistency;
    public final FitnessFunctions fitnessFunctions;
    private final SolutionProcessor processor;

    public CandidateSolution(Model metamodel, Model model) {
        this.editOperations = new ArrayList<>();
        this.model = model;
        this.metamodel = metamodel;
        this.fitnessFunctions = new FitnessFunctions(metamodel, model);
        this.processor = new SolutionProcessor();
    }

    public CandidateSolution(List<EditOperation> editOperations, Model model, Model metamodel) {
        this.editOperations = editOperations;
        this.model = model;
        this.metamodel = metamodel;
        this.fitnessFunctions = new FitnessFunctions(metamodel, model);
        this.processor = new SolutionProcessor();
    }

    public void setSharedFitness(double sharedFitness) {  
        this.sharedFitness = sharedFitness;
    }

    public double getSharedFitness() {
        return sharedFitness;
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

    public double getFitnessValue(int objective) {

        double objectiveValue = 0.0;
        if (objective == 0) {
            objectiveValue = currNvc;
        }
        if (objective == 1) {
            objectiveValue = currInconsistency;
        }

        objectiveValue += sharedFitness;

        return objectiveValue;
    }

    public void setFitnessValue(int objective) {
        Model revModel = processor.runProcessSolution(model, CandidateSolution.this);
        if (objective == 0) {
            currNvc = this.fitnessFunctions.nvc(metamodel, revModel);
        }

        if (objective == 1) {
            currInconsistency = this.fitnessFunctions.inconsistency(model, revModel);
        }
    }

    public void setFitnessValues() {   
        Model revModel = processor.runProcessSolution(model, CandidateSolution.this);
        currNvc = 0;
        currNvc = this.fitnessFunctions.nvc(metamodel, revModel);
        currNbOp = 0;
        //currNbOp = this.fitnessFunctions.nbOp(CandidateSolution.this);
        currInconsistency = 0;
        currInconsistency = this.fitnessFunctions.inconsistency(model, revModel);
    }
}