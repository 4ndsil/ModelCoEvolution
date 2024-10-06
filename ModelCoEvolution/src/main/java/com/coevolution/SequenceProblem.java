package com.coevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.uma.jmetal.problem.AbstractGenericProblem;

import com.coevolution.OCLGenerator.ConstraintDetail;
import com.coevolution.OCLModelValidator.BrokenConstraint;

public class SequenceProblem extends AbstractGenericProblem<CandidateSolution> {
    private final Map<EObject, List<ConstraintDetail>> ocl;
    private final EPackage corelangPackage;
    private final List<BrokenConstraint> brokenConstraints;

    public SequenceProblem(Map<EObject, List<ConstraintDetail>> ocl, List<BrokenConstraint> brokenConstraints, EPackage corelangPackage) {
        this.ocl = ocl;
        this.brokenConstraints = new ArrayList<>(brokenConstraints);
        this.corelangPackage = corelangPackage;
        setNumberOfVariables(1);
        setNumberOfObjectives(3);
        setName("SequenceProblem");
    }

    @Override
    public CandidateSolution evaluate(CandidateSolution solution) {
        Resource metamodel = ModelLoader.loadXMIModel("app_metamodel.xmi", corelangPackage);
        Resource metamodel_copy = SolutionProcessor.copyModel(metamodel); 
        Resource model = ModelLoader.loadXMIModel("app_model.xmi", corelangPackage);
        Resource model_copy = SolutionProcessor.copyModel(model);
        Resource revmodel = SolutionProcessor.runProcessSolution(model_copy, solution);
        Map<EObject, List<ConstraintDetail>> ocl_revised = OCLGenerator.generateOCLConstraints(revmodel, corelangPackage);
        solution.setFitnessValues(model_copy, metamodel_copy, revmodel, ocl_revised);
        return solution;
    }

    @Override
    public CandidateSolution createSolution() {
        CandidateSolution solution = new CandidateSolution(corelangPackage);
        Resource metamodel = ModelLoader.loadXMIModel("app_metamodel.xmi", corelangPackage);  
        solution.addRepairOperations(RepairOperationGenerator.getUniqueRepairSequence(metamodel, brokenConstraints));
        return solution;
    }
}