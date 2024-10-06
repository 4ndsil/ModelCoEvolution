package com.coevolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

public class OCLGenerator {

    public static Map<EObject, List<ConstraintDetail>> generateOCLConstraints(Resource metamodel, EPackage ePackage) {
        Map<EObject, List<ConstraintDetail>> oclExpressions = new HashMap<>();

        generateConstraintsForEObject(metamodel.getContents().get(0), oclExpressions, ePackage);

        return oclExpressions;
    }

    private static void generateConstraintsForEObject(EObject root_mm,
            Map<EObject, List<ConstraintDetail>> oclExpressions,
            EPackage ePackage) {
        
        List<EObject> assets = (List<EObject>) root_mm.eGet(root_mm.eClass().getEStructuralFeature("assets"));
        for (EObject asset : assets){
            OCLHelper<EClassifier, ?, ?, ?> helper = OCLHelperUtil.createHelper(ePackage, ePackage.getEClassifier("Root").getName());
            String assetName = safeToString(asset.eGet(asset.eClass().getEStructuralFeature("name")));
            String query1 = "self.assets->exists(a | a.name = '" + assetName + "')";
            try {
                addConstraint(oclExpressions, asset, "O1", helper.createQuery(query1));
            } catch (ParserException e) {
                e.printStackTrace();
            }
        }
  
        List<EObject> attackSteps = new ArrayList<>();
        for (EObject asset : assets){
            attackSteps.addAll((List<EObject>) asset.eGet(asset.eClass().getEStructuralFeature("attackSteps")));
        }
        generateConstraintsForAttackStep(attackSteps, oclExpressions, ePackage);
    
        List<EObject> associations = (List<EObject>) root_mm.eGet(root_mm.eClass().getEStructuralFeature("associations"));        
        generateConstraintsForAssociation(associations, oclExpressions, ePackage);        
    }

    private static void generateConstraintsForAttackStep(List<EObject> attackSteps,        
            Map<EObject, List<ConstraintDetail>> oclExpressions, EPackage ePackage) {
        for (EObject attackStep : attackSteps){
            OCLHelper<EClassifier, ?, ?, ?> helper = OCLHelperUtil.createHelper(ePackage, ePackage.getEClassifier("Asset").getName());     
            String stepName = safeToString(attackStep.eGet(attackStep.eClass().getEStructuralFeature("name")));
            String type = safeToString(attackStep.eGet(attackStep.eClass().getEStructuralFeature("type")));
            String query2 = "self.attackSteps->exists(a | a.name = '" + stepName + "')";
            try {
                addConstraint(oclExpressions, attackStep, "V1", helper.createQuery(query2));
            } catch (ParserException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateConstraintsForAssociation(List<EObject> associations, 
            Map<EObject, List<ConstraintDetail>> oclExpressions, EPackage ePackage) {
        for (EObject association : associations){
               OCLHelper<EClassifier, ?, ?, ?> helper = OCLHelperUtil.createHelper(ePackage, ePackage.getEClassifier("Root").getName());             
            String associationName = safeToString(association.eGet(association.eClass().getEStructuralFeature("name")));
            String leftAsset = extractSimpleName(safeToString(association.eGet(association.eClass().getEStructuralFeature("leftType"))));
            String rightAsset = extractSimpleName(safeToString(association.eGet(association.eClass().getEStructuralFeature("rightType"))));
            List<String> leftConnections = (List<String>) association.eGet(association.eClass().getEStructuralFeature("leftConnections"));
            List<String> rightConnections = (List<String>) association.eGet(association.eClass().getEStructuralFeature("rightConnections"));

            String expression = "self.associations->exists(a | a.name = '" + associationName + 
                    "' and a.leftType = '" + leftAsset +
                    "' and a.rightType = '" + rightAsset + 
                    "' and a.leftMultiplicityMin.oclAsType(Integer) <= " + leftConnections.size() + 
                    " and a.rightMultiplicityMin.oclAsType(Integer) <= " + rightConnections.size() + 
                    " and a.leftMultiplicityMax.oclAsType(Integer) >= " + leftConnections.size() + 
                    " and a.rightMultiplicityMax.oclAsType(Integer) >= " + rightConnections.size() + ")";
            try {
                addConstraint(oclExpressions, association, "L1", helper.createQuery(expression));
            } catch (ParserException e) {
                e.printStackTrace();
            }        
        }
    }

    private static void addConstraint(Map<EObject, List<ConstraintDetail>> oclExpressions,
            EObject object, String constraintExpression, OCLExpression queryExpression) {
        if (!oclExpressions.containsKey(object)) {
            oclExpressions.put(object, new ArrayList<>());
        }
        oclExpressions.get(object).add(new ConstraintDetail(queryExpression, constraintExpression));
    }

    private static String extractSimpleName(String href) {
        if (href != null && href.contains("#//")) {
            return href.substring(href.indexOf("#//") + 3);
        }
        return href;
    }

    private static String safeToString(Object value) {
        return value != null ? value.toString() : "";
    }

    public static class ConstraintDetail {
        private final OCLExpression expression;
        private final String constraintName;

        public ConstraintDetail(OCLExpression expression, String constraintName) {
            this.expression = expression;
            this.constraintName = constraintName;
        }

        public OCLExpression getExpression() {
            return expression;
        }

        public String getConstraintName() {
            return constraintName;
        }
    }
}
