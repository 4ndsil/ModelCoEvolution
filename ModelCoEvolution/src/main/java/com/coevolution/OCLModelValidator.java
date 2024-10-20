package com.coevolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.OCL;

import com.coevolution.OCLGenerator.ConstraintDetail;

public class OCLModelValidator {

   
    public static List<BrokenConstraint> validateModel(Resource metamodel, Resource model, Map<EObject, List<ConstraintDetail>> constraints) {
        OCL ocl = OCLHelperUtil.getOCLInstance();
        List<BrokenConstraint> brokenConstraints = new ArrayList<>();
        EObject root = metamodel.getContents().get(0);
        List<EObject> metamodelAssets = (List<EObject>) root.eGet(root.eClass().getEStructuralFeature("assets"));        
        for (EObject asset : metamodelAssets){                        
            validateAttackStepsAgainstConstraints(ocl, asset, constraints, brokenConstraints);            
        }
        return brokenConstraints;
    }
    
   private static void validateObjectsAgainstConstraints(OCL ocl, EObject object, Map<EObject, List<ConstraintDetail>> constraints, List<BrokenConstraint> brokenConstraints) {
        for (Map.Entry<EObject, List<ConstraintDetail>> entry : constraints.entrySet()) {
            if (!entry.getKey().eContainer().eClass().getName().equals("Root")){
                continue;
            }
            List<ConstraintDetail> constraintDetails = entry.getValue();
            for (ConstraintDetail constraintDetail : constraintDetails) {                             
                boolean result = ocl.check(object, constraintDetail.getExpression());
                if (result) {
                    break;
                }
                else{
                    brokenConstraints.add(new BrokenConstraint(entry.getKey(), constraintDetail.getConstraintName()));
                }
            }
        }
    }

    private static void validateAttackStepsAgainstConstraints(OCL ocl, EObject object, Map<EObject, List<ConstraintDetail>> constraints, List<BrokenConstraint> brokenConstraints) {
        for (Map.Entry<EObject, List<ConstraintDetail>> entry : constraints.entrySet()) {
            if (!entry.getKey().eClass().getName().equals("AttackStep")){
                continue;
            }
            if (!object.eGet(object.eClass().getEStructuralFeature("name")).toString().equals(entry.getKey().eContainer().eGet(entry.getKey().eContainer().eClass().getEStructuralFeature("name")).toString())){
                continue;
            }
            List<ConstraintDetail> constraintDetails = entry.getValue();
            for (ConstraintDetail constraintDetail : constraintDetails) {                             
                boolean result = ocl.check(object, constraintDetail.getExpression());
                if (result) {
                    break;
                }
                else{
                    brokenConstraints.add(new BrokenConstraint(entry.getKey(), constraintDetail.getConstraintName()));
                }
            }
        }
    }

    public static class BrokenConstraint {
        public final EObject object;
        public final String constraints;

        public BrokenConstraint(EObject object, String constraints) {
            this.object = object;
            this.constraints = constraints;
        }

        public EObject getObject() {
            return object;
        }

        public String getConstraint() {
            return constraints;
        }
    }
}