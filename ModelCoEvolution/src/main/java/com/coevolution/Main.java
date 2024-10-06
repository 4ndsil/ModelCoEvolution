package com.coevolution;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.crossover.impl.NPointCrossover;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.comparator.RankingAndCrowdingDistanceComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import com.coevolution.OCLGenerator.ConstraintDetail;
import com.coevolution.OCLModelValidator.BrokenConstraint;

public class Main {
    public static void main(String[] args) throws IOException {     

        EPackage corelangPackage = ModelLoader.loadEcorePackage("coreLang_metamodel.ecore");

        // metamodel
        Resource metamodel = ModelLoader.loadXMIModel("app_metamodel.xmi", corelangPackage);

        // model
        Resource model = ModelLoader.loadXMIModel("app_model.xmi", corelangPackage);

        Map<EObject, List<ConstraintDetail>> constraints = OCLGenerator.generateOCLConstraints(model, corelangPackage);

        List<BrokenConstraint> brokenConstraints = new ArrayList<>();

        brokenConstraints = OCLModelValidator.validateModel(metamodel, model, constraints);

        List<RepairOperation> ops = RepairOperationGenerator.getAllRepairOperations(metamodel, brokenConstraints);

        SequenceProblem problem = new SequenceProblem(constraints, brokenConstraints, corelangPackage);

        int maxEvaluations = 150;

        int populationSize = 250;

        CrossoverOperator<CandidateSolution> crossoverOperator = new NPointCrossover(0.77, 1);

        MutationOperator<CandidateSolution> mutationOperator = new SwapMutation(0.3, ops);

        Comparator<CandidateSolution> dominanceComparator = new DominanceComparator<>();

        SelectionOperator<List<CandidateSolution>, CandidateSolution> selectionOperator = new BinaryTournamentSelection<>(
                new RankingAndCrowdingDistanceComparator<>());

        SolutionListEvaluator<CandidateSolution> evaluator = new SequentialSolutionListEvaluator<>();

        Algorithm<List<CandidateSolution>> algorithm = new NSGAIIBuilder<>(            
                problem,
                crossoverOperator,
                mutationOperator,
                populationSize)
                .setDominanceComparator(dominanceComparator)
                .setMaxEvaluations(maxEvaluations)
                .setSelectionOperator(selectionOperator)
                .setSolutionListEvaluator(evaluator)
                .build();

                algorithm.run();
        
        CandidateSolution solution = null;
        double currNvc = 300.0;
        List<CandidateSolution> solutions = algorithm.getResult();
        for (CandidateSolution sol : solutions){
            Resource model_copy = SolutionProcessor.copyModel(model);
            Resource revmodel = SolutionProcessor.runProcessSolution(model_copy, sol);
            Map<EObject, List<ConstraintDetail>> ocl_revised = OCLGenerator.generateOCLConstraints(revmodel, corelangPackage);
            sol.setFitnessValues(model, metamodel, revmodel, ocl_revised);
            if (sol.getNvc() < currNvc){
                currNvc = sol.getNvc();
                solution = sol;
            }
        }

        try {
            FileWriter myWriter = new FileWriter("solution.txt");
            for (RepairOperation op : solution.getRepairOperations()){
                if (op instanceof CreateOperation) {
                    myWriter.write("Create op: \n");
                    myWriter.write("Create element:" + ((CreateOperation) op).getCreateElement().eGet(((CreateOperation) op).getCreateElement().eClass().getEStructuralFeature("name")) + "\n\n");
                    if(((CreateOperation) op).getTargetElement().eClass().getName().equals("Root")){
                        myWriter.write("Target element: Root");
                    }
                    else{
                        myWriter.write("Target element:" + ((CreateOperation) op).getTargetElement().eGet(((CreateOperation) op).getTargetElement().eClass().getEStructuralFeature("name")) + " " + ((CreateOperation) op).getTargetElement().eGet(((CreateOperation) op).getTargetElement().eClass().getEStructuralFeature("eid")) + "\n\n");
                    }                    
                } else if (op instanceof DeleteOperation) {
                    myWriter.write("Delete op: \n");
                    myWriter.write("Delete element:" + ((DeleteOperation) op).getDeleteElement().eGet(((DeleteOperation) op).getDeleteElement().eClass().getEStructuralFeature("name")) + "\n\n");
                       if(((DeleteOperation) op).getTargetElement().eClass().getName().equals("Root")){
                        myWriter.write("Target element: Root");
                    }
                    else{
                        myWriter.write("Target element:" + ((DeleteOperation) op).getTargetElement().eGet(((DeleteOperation) op).getTargetElement().eClass().getEStructuralFeature("name")) + " " + ((DeleteOperation) op).getTargetElement().eGet(((DeleteOperation) op).getTargetElement().eClass().getEStructuralFeature("eid")) + "\n\n");
                    }                    
                } else if (op instanceof RetypeOperation) {
                    myWriter.write("Retype op: \n");
                    myWriter.write("Retype element:" + ((RetypeOperation) op).getNewType() + "\n\n");
                }
            }          
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Resource model_1 = ModelLoader.loadXMIModel("app_model.xmi", corelangPackage);
        Resource revised_model = SolutionProcessor.runProcessSolution(model_1, solution);   
        XMIBuilder.saveEObjectToXMI(revised_model.getContents().get(0), corelangPackage, "app_model_revised.xmi");
    }
}