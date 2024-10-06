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

public class EcoreMetamodelBuilder {

    public static EPackage buildEcoreMetamodel() {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

        Resource resource = resourceSet.createResource(URI.createURI("coreLang_metamodel.ecore"));

        // EPackage
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("coreLang_metamodel");
        ePackage.setNsPrefix("coreLang_metamodel");
        ePackage.setNsURI("http://www.example.org/coreLang_metamodel");

        // Root
        EClass rootEClass = EcoreFactory.eINSTANCE.createEClass();
        rootEClass.setName("Root");

        // Asset
        EClass assetEClass = EcoreFactory.eINSTANCE.createEClass();
        assetEClass.setName("Asset");

        EAttribute nameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        nameAttr.setName("name");
        nameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(nameAttr);

        EAttribute metaconceptAttr = EcoreFactory.eINSTANCE.createEAttribute();
        metaconceptAttr.setName("metaconcept");
        metaconceptAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(metaconceptAttr);
    
        EAttribute eidAttr = EcoreFactory.eINSTANCE.createEAttribute();
        eidAttr.setName("eid");
        eidAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(eidAttr);

        EAttribute categoryAttr = EcoreFactory.eINSTANCE.createEAttribute();
        categoryAttr.setName("category");
        categoryAttr.setEType(EcorePackage.eINSTANCE.getEString());
        assetEClass.getEStructuralFeatures().add(categoryAttr);

        EAttribute isAbstractAttr = EcoreFactory.eINSTANCE.createEAttribute();
        isAbstractAttr.setName("isAbstract");
        isAbstractAttr.setEType(EcorePackage.eINSTANCE.getEBoolean());
        assetEClass.getEStructuralFeatures().add(isAbstractAttr);

        // Asset to Super Asset
        EReference superAssetRef = EcoreFactory.eINSTANCE.createEReference();
        superAssetRef.setName("superAsset");
        superAssetRef.setEType(assetEClass); // This is a self-reference to another Asset
        assetEClass.getEStructuralFeatures().add(superAssetRef);

        // AttackStep
        EClass attackStepEClass = EcoreFactory.eINSTANCE.createEClass();
        attackStepEClass.setName("AttackStep");

        EAttribute attackStepNameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        attackStepNameAttr.setName("name");
        attackStepNameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        attackStepEClass.getEStructuralFeatures().add(attackStepNameAttr);

        EAttribute attackStepTypeAttr = EcoreFactory.eINSTANCE.createEAttribute();
        attackStepTypeAttr.setName("type");
        attackStepTypeAttr.setEType(EcorePackage.eINSTANCE.getEString());
        attackStepEClass.getEStructuralFeatures().add(attackStepTypeAttr);

        EAttribute attackStepMetaAttr = EcoreFactory.eINSTANCE.createEAttribute();
        attackStepMetaAttr.setName("meta");
        attackStepMetaAttr.setEType(EcorePackage.eINSTANCE.getEString());
        attackStepEClass.getEStructuralFeatures().add(attackStepMetaAttr);

        // Asset to AttackStep
        EReference attackStepsRef = EcoreFactory.eINSTANCE.createEReference();
        attackStepsRef.setName("attackSteps");
        attackStepsRef.setEType(attackStepEClass);
        attackStepsRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        attackStepsRef.setContainment(true);
        assetEClass.getEStructuralFeatures().add(attackStepsRef);

        // Root to Asset
        EReference assetsRef = EcoreFactory.eINSTANCE.createEReference();
        assetsRef.setName("assets");
        assetsRef.setEType(assetEClass);
        assetsRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        assetsRef.setContainment(true);
        rootEClass.getEStructuralFeatures().add(assetsRef);

        // Association
        EClass associationEClass = EcoreFactory.eINSTANCE.createEClass();
        associationEClass.setName("Association");

        EAttribute associationnameAttr = EcoreFactory.eINSTANCE.createEAttribute();
        associationnameAttr.setName("name");
        associationnameAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(associationnameAttr);

        EAttribute metaAttr = EcoreFactory.eINSTANCE.createEAttribute();
        metaAttr.setName("meta");
        metaAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(metaAttr);

        EAttribute associationLeftConnectionAttr = EcoreFactory.eINSTANCE.createEAttribute();
        associationLeftConnectionAttr.setName("leftConnectionName");
        associationLeftConnectionAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(associationLeftConnectionAttr);
             
        EAttribute associationRightConnectionAttr = EcoreFactory.eINSTANCE.createEAttribute();
        associationRightConnectionAttr.setName("rightConnectionName");
        associationRightConnectionAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(associationRightConnectionAttr);

        EAttribute leftTypeAttr = EcoreFactory.eINSTANCE.createEAttribute();
        leftTypeAttr.setName("leftType");
        leftTypeAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(leftTypeAttr);
             
        EAttribute rightTypeAttr = EcoreFactory.eINSTANCE.createEAttribute();
        rightTypeAttr.setName("rightType");
        rightTypeAttr.setEType(EcorePackage.eINSTANCE.getEString());
        associationEClass.getEStructuralFeatures().add(rightTypeAttr);

        // Association to Asset
        EReference associationLeftAssetsRef = EcoreFactory.eINSTANCE.createEReference();
        associationLeftAssetsRef.setName("leftConnections");
        associationLeftAssetsRef.setEType(assetEClass);
        associationLeftAssetsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        associationLeftAssetsRef.setContainment(false);
        associationEClass.getEStructuralFeatures().add(associationLeftAssetsRef);

        // Association to Asset
        EReference associationRightAssetsRef = EcoreFactory.eINSTANCE.createEReference();
        associationRightAssetsRef.setName("rightConnections");
        associationRightAssetsRef.setEType(assetEClass);
        associationRightAssetsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        associationRightAssetsRef.setContainment(false);
        associationEClass.getEStructuralFeatures().add(associationRightAssetsRef);

        // Asset to Association
        EReference associationsRef = EcoreFactory.eINSTANCE.createEReference();
        associationsRef.setName("associations");
        associationsRef.setEType(associationEClass);
        associationsRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        associationsRef.setContainment(false);
        associationsRef.setEOpposite(associationLeftAssetsRef);
        assetEClass.getEStructuralFeatures().add(associationsRef);

        associationLeftAssetsRef.setEOpposite(associationsRef);

        associationRightAssetsRef.setEOpposite(associationsRef);

        EAttribute leftMultiplicityMin = EcoreFactory.eINSTANCE.createEAttribute();
        leftMultiplicityMin.setName("leftMultiplicityMin");
        leftMultiplicityMin.setEType(EcorePackage.eINSTANCE.getEInt());
        associationEClass.getEStructuralFeatures().add(leftMultiplicityMin);

        EAttribute leftMultiplicityMax = EcoreFactory.eINSTANCE.createEAttribute();
        leftMultiplicityMax.setName("leftMultiplicityMax");
        leftMultiplicityMax.setEType(EcorePackage.eINSTANCE.getEInt());
        associationEClass.getEStructuralFeatures().add(leftMultiplicityMax);

        EAttribute rightMultiplicityMin = EcoreFactory.eINSTANCE.createEAttribute();
        rightMultiplicityMin.setName("rightMultiplicityMin");
        rightMultiplicityMin.setEType(EcorePackage.eINSTANCE.getEInt());
        associationEClass.getEStructuralFeatures().add(rightMultiplicityMin);

        EAttribute rightMultiplicityMax = EcoreFactory.eINSTANCE.createEAttribute();
        rightMultiplicityMax.setName("rightMultiplicityMax");
        rightMultiplicityMax.setEType(EcorePackage.eINSTANCE.getEInt());
        associationEClass.getEStructuralFeatures().add(rightMultiplicityMax);

        // Root to Association
        EReference associationsRefRoot = EcoreFactory.eINSTANCE.createEReference();
        associationsRefRoot.setName("associations");
        associationsRefRoot.setEType(associationEClass);
        associationsRefRoot.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
        associationsRefRoot.setContainment(true);
        rootEClass.getEStructuralFeatures().add(associationsRefRoot);

        // Add the classes to the package
        ePackage.getEClassifiers().add(assetEClass);
        ePackage.getEClassifiers().add(attackStepEClass);
        ePackage.getEClassifiers().add(associationEClass);
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

