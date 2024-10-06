package com.coevolution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModelUtils {
    public static boolean associationsMatch(EObject assoc1, EObject assoc2) {
        EObject leftAsset1 = (EObject) assoc1.eGet(assoc1.eClass().getEStructuralFeature("leftAsset"));
        EObject rightAsset1 = (EObject) assoc1.eGet(assoc1.eClass().getEStructuralFeature("rightAsset"));
        EObject leftAsset2 = (EObject) assoc2.eGet(assoc2.eClass().getEStructuralFeature("leftAsset"));
        EObject rightAsset2 = (EObject) assoc2.eGet(assoc2.eClass().getEStructuralFeature("rightAsset"));
        
        return leftAsset1.equals(leftAsset2) && rightAsset1.equals(rightAsset2);
    }

    public static EObject findMatchingReference(EObject obj, EObject reference) {
        EClass eClass = obj.eClass();
        
        while (eClass != null) {
            for (EStructuralFeature feature : eClass.getEStructuralFeatures()) {
                if (feature instanceof EReference) {
                    EReference ref = (EReference) feature;
                    if (ref.getEType().equals(reference.eClass())) {
                        return (EObject) obj.eGet(ref);
                    }
                }
            }
            eClass = eClass.getESuperTypes().isEmpty() ? null : eClass.getESuperTypes().get(0);
        }
        
        return null;
    }

    public static List<EObject> getAllAssociations(EObject root) {
        List<EObject> associations = new ArrayList<>();
        traverseModel(root, associations);
        return associations;
    }

    public static void traverseModel(EObject current, List<EObject> associations) {
        if (isAssociation(current)) {
            associations.add(current);
        }
        for (EObject child : current.eContents()) {
            traverseModel(child, associations);
        }
    }

    public static boolean isAssociation(EObject obj) {
        return obj.eClass().getName().equals("Association");
    }
}
