package com.coevolution;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class XMIBuilder {

    public static void saveEObjectToXMI(EObject eObject, EPackage ePackage, String filePath) {
        EFactory factory = ePackage.getEFactoryInstance();

        EClass rootEClass = (EClass) ePackage.getEClassifier("Root");
        EClass assetEClass = (EClass) ePackage.getEClassifier("Asset");
        EClass attackStepEClass = (EClass) ePackage.getEClassifier("AttackStep");
        EClass associationEClass = (EClass) ePackage.getEClassifier("Association");

        EObject root = factory.create(rootEClass);

        List<EObject> assets = (List<EObject>) eObject.eGet(eObject.eClass().getEStructuralFeature("assets"));
        for (EObject assetObj : assets) {
            EObject asset = factory.create(assetEClass);
            asset.eSet(assetEClass.getEStructuralFeature("name"), assetObj.eGet(assetObj.eClass().getEStructuralFeature("name")));
            asset.eSet(assetEClass.getEStructuralFeature("eid"), assetObj.eGet(assetObj.eClass().getEStructuralFeature("eid")));

            List<EObject> attackSteps = (List<EObject>) assetObj.eGet(assetObj.eClass().getEStructuralFeature("attackSteps"));
            for (EObject attackStepObj : attackSteps) {
                EObject attackStep = factory.create(attackStepEClass);
                attackStep.eSet(attackStepEClass.getEStructuralFeature("name"), attackStepObj.eGet(attackStepObj.eClass().getEStructuralFeature("name")));
                attackStep.eSet(attackStepEClass.getEStructuralFeature("type"), attackStepObj.eGet(attackStepObj.eClass().getEStructuralFeature("type")));
                ((EList<EObject>) asset.eGet(assetEClass.getEStructuralFeature("attackSteps"))).add(attackStep);
            }

            ((EList<EObject>) root.eGet(rootEClass.getEStructuralFeature("assets"))).add(asset);
        }

        List<EObject> associations = (List<EObject>) eObject.eGet(eObject.eClass().getEStructuralFeature("associations"));
        for (EObject associationObj : associations) {
            EObject association = factory.create(associationEClass);
            association.eSet(associationEClass.getEStructuralFeature("name"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("name")));
            association.eSet(associationEClass.getEStructuralFeature("leftConnectionName"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("leftConnectionName")));
            association.eSet(associationEClass.getEStructuralFeature("leftType"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("leftType")));
            association.eSet(associationEClass.getEStructuralFeature("leftConnections"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("leftConnections")));
            association.eSet(associationEClass.getEStructuralFeature("rightConnectionName"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("rightConnectionName")));
            association.eSet(associationEClass.getEStructuralFeature("rightType"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("rightType")));
            association.eSet(associationEClass.getEStructuralFeature("rightConnections"), associationObj.eGet(associationObj.eClass().getEStructuralFeature("rightConnections")));

            ((EList<EObject>) root.eGet(rootEClass.getEStructuralFeature("associations"))).add(association);
        }

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        Resource resource = resourceSet.createResource(URI.createURI(filePath));
        resource.getContents().add(root);

        try {
            resource.save(null);
            System.out.println("Model saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

