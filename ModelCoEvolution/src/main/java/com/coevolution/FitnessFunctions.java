package com.coevolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.coevolution.OCLGenerator.ConstraintDetail;
import com.coevolution.OCLModelValidator.BrokenConstraint;

public class FitnessFunctions {

    public static double nvc(Resource metamodel, Resource model, Map<EObject, List<ConstraintDetail>> constraints) {
        List<BrokenConstraint> brokenConstraints = new ArrayList<>();
        brokenConstraints = OCLModelValidator.validateModel(metamodel, model, constraints);
        return brokenConstraints.size();
    }

    // fitness ii - number of operations
    public static double nbOp(CandidateSolution solution) {
        return solution.getRepairOperations().size();        
    }

    // fitness iii - inconsistency
    public static double inconsistency(Resource initialModel, Resource revisedModel) {
        EObject initalRoot = initialModel.getContents().get(0);
        EObject revisedRoot = revisedModel.getContents().get(0);
        Set<String> initialIdentifiers = extractIdentifiers(initalRoot);
        Set<String> revisedIdentifiers = extractIdentifiers(revisedRoot);

        double similarity = computeSimilarity(initialIdentifiers, revisedIdentifiers);
        double inconsistency = 1 - similarity;

        return inconsistency;
    }

    private static Set<String> extractIdentifiers(EObject element) {
        Set<String> identifiers = new HashSet<>();
        List<EObject> assets = (List<EObject>) element.eGet(element.eClass().getEStructuralFeature("assets"));
        for (EObject asset : assets){
            List<EObject> attackSteps = (List<EObject>) asset.eGet(asset.eClass().getEStructuralFeature("attackSteps"));
            identifiers.addAll(extractIdentifiers(attackSteps));
        }
        List<EObject> associations = (List<EObject>) element.eGet(element.eClass().getEStructuralFeature("associations"));
        
        identifiers.addAll(extractIdentifiers(assets));
        identifiers.addAll(extractIdentifiers(associations));        

        return identifiers;
    }

    private static Set<String> extractIdentifiers(List<EObject> elements) {
        Set<String> identifiers = new HashSet<>();
        for (EObject element : elements){
            String name = (String) element.eGet(element.eClass().getEStructuralFeature("name"));
            identifiers.add(name);
        }

        return identifiers;
    }

    private static double computeSimilarity(Set<String> initialIdentifiers, Set<String> revisedIdentifiers) {
        Set<String> commonIdentifiers = new HashSet<>(initialIdentifiers);
        commonIdentifiers.retainAll(revisedIdentifiers);

        int maxSize = Math.max(initialIdentifiers.size(), revisedIdentifiers.size());
        return maxSize == 0 ? 1.0 : (double) commonIdentifiers.size() / maxSize;
    }
}