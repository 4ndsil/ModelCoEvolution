package com.coevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.uma.jmetal.solution.AbstractSolution;

import com.coevolution.OCLGenerator.ConstraintDetail;

public class CandidateSolution extends AbstractSolution<RepairOperation> {

    private final List<RepairOperation> operations;
    private final EPackage corelangPackage;
    private double currNvc;
    private double currNbOp;
    private double currInconsistency;

    public CandidateSolution(EPackage corelangPackage) {
        super(1,2,3);
        this.operations = new ArrayList<>();
        this.corelangPackage = corelangPackage;  

    }

    @Override
    public CandidateSolution copy() {
        CandidateSolution copy = new CandidateSolution(corelangPackage);        
        copy.operations.addAll(this.operations);
        copy.currNvc = this.currNvc;
        copy.currNbOp = this.currNbOp;
        copy.currInconsistency = this.currInconsistency;

        return copy;
    }

    @Override
    public double[] objectives() {
        double [] objectives = {currNvc, currNbOp, currInconsistency}; 
        return objectives;
    }

    public double getObjective(int index) {
        double[] objectives = objectives();
        double objective = objectives[index];
        return objective;
    }

    public List<RepairOperation> getRepairOperations() {
        return operations;
    }

    public void addRepairOperation(RepairOperation op) {
        operations.add(op);
    }

    public void addRepairOperations(List<RepairOperation> ops) {
        operations.addAll(ops);
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

    public void setFitnessValues(Resource model, Resource metamodel, Resource revModel, Map<EObject, List<ConstraintDetail>> ocl) {
        currNvc = 0;
        currNvc = FitnessFunctions.nvc(metamodel, revModel, ocl);
        currNbOp = 0;
        currNbOp = FitnessFunctions.nbOp(this);
        currInconsistency = 0;
        currInconsistency = FitnessFunctions.inconsistency(model, revModel);
    }
}

