package com.malecorebuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class EcoreMetamodelPopulator {

    public static void populateModel(EPackage ePackage, String intputFile, String outputFileName) throws IOException {
        JsonNode rootNode = JsonParser.parseJson(intputFile);
        EClass assetEClass = (EClass) ePackage.getEClassifier("Asset");
        EClass attackStepEClass = (EClass) ePackage.getEClassifier("AttackStep");
        EClass rootEClass = (EClass) ePackage.getEClassifier("Root");
        EClass associationEClass = (EClass) ePackage.getEClassifier("Association");      

        EFactory factory = ePackage.getEFactoryInstance();

        EObject root = factory.create(rootEClass);

        Iterator<JsonNode> assets = rootNode.path("assets").elements();

        List<String> modelObjects = List.of(
            "ConnectionRule",
            "Application",
            "RoutingFirewall"
        );

        Map<String, JsonNode> assetMap = new HashMap<>();
        while (assets.hasNext()) {
            JsonNode assetNode = assets.next();
            assetMap.put(assetNode.path("name").asText(), assetNode);
        }

        for (String modelObject : modelObjects) {
            JsonNode assetNode = assetMap.get(modelObject);
                EObject asset = factory.create(assetEClass);
                String superAssetName = assetNode.path("superAsset").asText();
                EObject superAsset = findAssetByName(root, superAssetName); 
                asset.eSet(assetEClass.getEStructuralFeature("name"), assetNode.path("name").asText());
                asset.eSet(assetEClass.getEStructuralFeature("category"), assetNode.path("category").asText());
                asset.eSet(assetEClass.getEStructuralFeature("isAbstract"), assetNode.path("isAbstract").asBoolean());
                asset.eSet(assetEClass.getEStructuralFeature("superAsset"), superAsset);
    
                Iterator<JsonNode> attackSteps = assetNode.path("attackSteps").elements();
                while (attackSteps.hasNext()) {
                    JsonNode attackStepNode = attackSteps.next();
                    JsonNode tagsNode = attackStepNode.path("tags");
                    String type = attackStepNode.path("type").asText();
                    boolean isEntrypoint = false;
                    for (JsonNode tag : (ArrayNode) tagsNode) {
                        if (tag.asText().equals("entrypoint")){
                            isEntrypoint = true;
                        }
                    }
                    if (isEntrypoint || type.equals("defense")) {
                        EObject attackStep = factory.create(attackStepEClass);
                        attackStep.eSet(attackStepEClass.getEStructuralFeature("name"), attackStepNode.path("name").asText());
                        attackStep.eSet(attackStepEClass.getEStructuralFeature("type"), type);
                        attackStep.eSet(attackStepEClass.getEStructuralFeature("meta"), attackStepNode.path("meta").path("user").asText());
        
                        ((EList<EObject>) asset.eGet(assetEClass.getEStructuralFeature("attackSteps"))).add(attackStep);
                    }                                                    
                }

            ((EList<EObject>) root.eGet(rootEClass.getEStructuralFeature("assets"))).add(asset);        
        }

        JsonNode associationsNode = rootNode.path("associations");
        if (associationsNode != null && associationsNode.isArray()) {
            int i = 1;
            for (JsonNode associationNode : associationsNode) {
                String associationName = associationNode.path("name").asText();
                String leftAssetName = associationNode.path("leftAsset").asText();
                String leftMin = associationNode.path("leftMultiplicity").path("min").asText();
                String leftMax = associationNode.path("leftMultiplicity").path("max").asText();
                String rightAssetName = associationNode.path("rightAsset").asText();
                String rightMin = associationNode.path("rightMultiplicity").path("min").asText();
                String rightMax = associationNode.path("rightMultiplicity").path("max").asText();

                if (modelObjects.contains(leftAssetName) && modelObjects.contains(rightAssetName)){

                    EObject association = factory.create(associationEClass);
                    association.eSet(associationEClass.getEStructuralFeature("name"), associationName);
                    association.eSet(associationEClass.getEStructuralFeature("leftType"), leftAssetName);
                    association.eSet(associationEClass.getEStructuralFeature("rightType"), rightAssetName);        
                    
                     if (leftMin.isBlank() || leftMin.isEmpty() || leftMin.equals("null")){
                        association.eSet(associationEClass.getEStructuralFeature("leftMultiplicityMin"), 0);
                    }
                    else{
                        association.eSet(associationEClass.getEStructuralFeature("leftMultiplicityMin"), Integer.parseInt(leftMin));
                    }

                    if (leftMax.equals("*") || leftMax.isBlank() || leftMax.isEmpty() || leftMax.equals("null")){
                        association.eSet(associationEClass.getEStructuralFeature("leftMultiplicityMax"), Integer.MAX_VALUE);
                    }
                    else{
                        association.eSet(associationEClass.getEStructuralFeature("leftMultiplicityMax"), Integer.parseInt(leftMax));
                    }

                    if (rightMin.isBlank() || rightMin.isEmpty() || rightMin.equals("null")){
                        association.eSet(associationEClass.getEStructuralFeature("rightMultiplicityMin"), 0);
                    }
                    else{
                        association.eSet(associationEClass.getEStructuralFeature("rightMultiplicityMin"), Integer.parseInt(rightMin));
                    }

                    if (rightMax.equals("*") || rightMax.isBlank() || rightMax.isEmpty() || rightMax.equals("null")){
                        association.eSet(associationEClass.getEStructuralFeature("rightMultiplicityMax"), Integer.MAX_VALUE);
                    }
                    else{
                        association.eSet(associationEClass.getEStructuralFeature("rightMultiplicityMax"), Integer.parseInt(rightMax));
                    }    

                    ((EList<EObject>) root.eGet(rootEClass.getEStructuralFeature("associations"))).add(association);
                
                }
            }
            i++;
        }

        // save populated model
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        Resource resource = resourceSet.createResource(URI.createURI(outputFileName));
        resource.getContents().add(root);

        try {
            resource.save(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static EObject findAssetByName(EObject root, String assetName) {
        EStructuralFeature assetsFeature = root.eClass().getEStructuralFeature("assets");
        if (assetsFeature != null) {
            EList<EObject> assets = (EList<EObject>) root.eGet(assetsFeature);
            for (EObject asset : assets) {
                EStructuralFeature nameFeature = asset.eClass().getEStructuralFeature("name");
                if (nameFeature != null && assetName.equals(asset.eGet(nameFeature))) {
                    return asset;
                }
            }
        }
        return null;
    }
}



