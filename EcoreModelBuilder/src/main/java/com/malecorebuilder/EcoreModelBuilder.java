package com.malecorebuilder;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EcoreModelBuilder {

    public static EPackage buildEcoreModel() {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
    
        Resource resource = resourceSet.createResource(URI.createURI("network_model.ecore"));
    
        // EPackage
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("network_model");
        ePackage.setNsPrefix("network_model");
        ePackage.setNsURI("http://www.example.org/network_model");
    
        // Asset
        EClass assetEClass = EcoreFactory.eINSTANCE.createEClass();
        assetEClass.setName("Asset");
    
        EAttribute assetNameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        assetNameAttr.setName("name");
        assetNameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(assetNameAttr);
    
        EAttribute metaconceptAttr = EcoreFactory.eINSTANCE.createEAttribute();
        metaconceptAttr.setName("metaconcept");
        metaconceptAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(metaconceptAttr);
    
        EAttribute eidAttr = EcoreFactory.eINSTANCE.createEAttribute();
        eidAttr.setName("eid");
        eidAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(eidAttr);

        // AttackStep
        EClass attackStepEClass = EcoreFactory.eINSTANCE.createEClass();
        attackStepEClass.setName("AttackStep");

        EAttribute attackStepNameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        attackStepNameAttr.setName("name");
        attackStepNameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        attackStepEClass.getEStructuralFeatures().add(attackStepNameAttr);

        // Asset to AttackStep (Containment)
        EReference attackStepRef = EcoreFactory.eINSTANCE.createEReference();
        attackStepRef.setName("attackSteps");
        attackStepRef.setEType(attackStepEClass);
        attackStepRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        attackStepRef.setContainment(true);
        assetEClass.getEStructuralFeatures().add(attackStepRef);
    
        // Defense
        EClass defenseEClass = EcoreFactory.eINSTANCE.createEClass();
        defenseEClass.setName("Defense");
    
        EAttribute defenseNameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        defenseNameAttr.setName("name");
        defenseNameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        defenseEClass.getEStructuralFeatures().add(defenseNameAttr);
    
        EAttribute defenseValueAttr = EcoreFactory.eINSTANCE.createEAttribute();
        defenseValueAttr.setName("value");
        defenseValueAttr.setEType(EcorePackage.eINSTANCE.getEString());
        defenseEClass.getEStructuralFeatures().add(defenseValueAttr);
    
        // Asset to Defense (Containment)
        EReference defensesRef = EcoreFactory.eINSTANCE.createEReference();
        defensesRef.setName("defenses");
        defensesRef.setEType(defenseEClass);
        defensesRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        defensesRef.setContainment(true);
        assetEClass.getEStructuralFeatures().add(defensesRef);
    
        // Association
        EClass associationEClass = EcoreFactory.eINSTANCE.createEClass();
        associationEClass.setName("Association");
    
        EAttribute associationMetaconceptAttr = EcoreFactory.eINSTANCE.createEAttribute();
        associationMetaconceptAttr.setName("metaconcept");
        associationMetaconceptAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(associationMetaconceptAttr);

        EAttribute associationLeftConnectionAttr = EcoreFactory.eINSTANCE.createEAttribute();
        associationLeftConnectionAttr.setName("leftConnectionName");
        associationLeftConnectionAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(associationLeftConnectionAttr);

        EReference associationLeftAssetsRef = EcoreFactory.eINSTANCE.createEReference();
        associationLeftAssetsRef.setName("leftConnections");
        associationLeftAssetsRef.setEType(assetEClass);
        associationLeftAssetsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        associationLeftAssetsRef.setContainment(false);
        associationEClass.getEStructuralFeatures().add(associationLeftAssetsRef);

        EAttribute associationRightConnectionAttr = EcoreFactory.eINSTANCE.createEAttribute();
        associationRightConnectionAttr.setName("rightConnectionName");
        associationRightConnectionAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(associationRightConnectionAttr);

        EReference associationRightAssetsRef = EcoreFactory.eINSTANCE.createEReference();
        associationRightAssetsRef.setName("rightConnections");
        associationRightAssetsRef.setEType(assetEClass);
        associationRightAssetsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        associationRightAssetsRef.setContainment(false);
        associationEClass.getEStructuralFeatures().add(associationRightAssetsRef);
    
        // Attacker
        EClass attackerEClass = EcoreFactory.eINSTANCE.createEClass();
        attackerEClass.setName("Attacker");
        
        EAttribute attackerIdAttr = EcoreFactory.eINSTANCE.createEAttribute();
        attackerIdAttr.setName("id");
        attackerIdAttr.setEType(EcorePackage.eINSTANCE.getEString());
        attackerEClass.getEStructuralFeatures().add(attackerIdAttr);

        EAttribute attackerNameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        attackerNameAttr.setName("name");
        attackerNameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        attackerEClass.getEStructuralFeatures().add(attackerNameAttr);

        // Attacker to Asset
        EReference entrypointRef = EcoreFactory.eINSTANCE.createEReference();
        entrypointRef.setName("entryPoints");
        entrypointRef.setEType(assetEClass);
        entrypointRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        entrypointRef.setContainment(false);
        attackerEClass.getEStructuralFeatures().add(entrypointRef);

        // Root
        EClass rootEClass = EcoreFactory.eINSTANCE.createEClass();
        rootEClass.setName("Root");
    
        EReference assetsRef = EcoreFactory.eINSTANCE.createEReference();
        assetsRef.setName("assets");
        assetsRef.setEType(assetEClass);
        assetsRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        assetsRef.setContainment(true);
        rootEClass.getEStructuralFeatures().add(assetsRef);
    
        EReference associationsRefRoot = EcoreFactory.eINSTANCE.createEReference();
        associationsRefRoot.setName("associations");
        associationsRefRoot.setEType(associationEClass);
        associationsRefRoot.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        associationsRefRoot.setContainment(true);
        rootEClass.getEStructuralFeatures().add(associationsRefRoot);
    
        EReference attackersRefRoot = EcoreFactory.eINSTANCE.createEReference();
        attackersRefRoot.setName("attackers");
        attackersRefRoot.setEType(attackerEClass);
        attackersRefRoot.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        attackersRefRoot.setContainment(true);
        rootEClass.getEStructuralFeatures().add(attackersRefRoot);
    
        // Add the classes to the package
        ePackage.getEClassifiers().add(assetEClass);
        ePackage.getEClassifiers().add(defenseEClass);
        ePackage.getEClassifiers().add(attackStepEClass);
        ePackage.getEClassifiers().add(associationEClass);
        ePackage.getEClassifiers().add(attackerEClass);
        ePackage.getEClassifiers().add(rootEClass);
    
        // Add the package to the resource
        resource.getContents().add(ePackage);
    
        // Save the resource to the file
        try {
            resource.save(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return ePackage;
    }
}
    

