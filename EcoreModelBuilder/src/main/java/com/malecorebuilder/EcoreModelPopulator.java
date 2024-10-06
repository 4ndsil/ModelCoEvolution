package com.malecorebuilder;

import java.io.IOException;
import java.util.ArrayList;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.fasterxml.jackson.databind.JsonNode;

public class EcoreModelPopulator {

    public static void populateModel(EPackage ePackage, String inputFile, String outputFileName) throws IOException {
        JsonNode rootNode = JsonParser.parseJson(inputFile);

        EClass assetEClass = (EClass) ePackage.getEClassifier("Asset");
        EClass attackStepEClass = (EClass) ePackage.getEClassifier("AttackStep");
        EClass rootEClass = (EClass) ePackage.getEClassifier("Root");
        EClass associationEClass = (EClass) ePackage.getEClassifier("Association");      

        EFactory factory = ePackage.getEFactoryInstance();

        EObject root = factory.create(rootEClass);

        Iterator<JsonNode> assets = rootNode.path("assets").elements();
        Map<String, EObject> assetMap = new HashMap<>();

        while (assets.hasNext()) {
            JsonNode assetNode = assets.next();
            EObject asset = factory.create(assetEClass);
            asset.eSet(assetEClass.getEStructuralFeature("name"), assetNode.path("metaconcept").asText());
            asset.eSet(assetEClass.getEStructuralFeature("eid"), assetNode.path("eid").asText());
            
            JsonNode defenseNode = assetNode.path("defenses");
            if (defenseNode != null && defenseNode.isObject()) {
                Iterator<Map.Entry<String, JsonNode>> defenses = defenseNode.fields();
                while (defenses.hasNext()) {
                    Map.Entry<String, JsonNode> defense = defenses.next();
                    String defenseName = defense.getKey();
                    EObject defenseObj = factory.create(attackStepEClass);
                    defenseObj.eSet(attackStepEClass.getEStructuralFeature("name"), defenseName);
                    defenseObj.eSet(attackStepEClass.getEStructuralFeature("type"), "defense");
                    ((EList<EObject>) asset.eGet(asset.eClass().getEStructuralFeature("attackSteps"))).add(defenseObj);                                   
                }
            }
            ((EList<EObject>) root.eGet(rootEClass.getEStructuralFeature("assets"))).add(asset);
                    assetMap.put(assetNode.path("eid").asText(), asset);
        }

        Iterator<JsonNode> associations = rootNode.path("associations").elements();
        while (associations.hasNext()) {
            JsonNode associationNode = associations.next();
            EObject associationObj = factory.create(associationEClass);
            
            associationObj.eSet(associationEClass.getEStructuralFeature("name"), associationNode.path("metaconcept").asText());

            JsonNode associationDetailsNode = associationNode.path("association");
            Iterator<Map.Entry<String, JsonNode>> fields = associationDetailsNode.fields();
            List<Map.Entry<String, JsonNode>> fieldsList = new ArrayList<>();
            fields.forEachRemaining(fieldsList::add);

            // left connections
            Map.Entry<String, JsonNode> leftField = fieldsList.get(0);
            String leftName = leftField.getKey();
            JsonNode leftAssetIdArrayNode = leftField.getValue();
            associationObj.eSet(associationEClass.getEStructuralFeature("leftConnectionName"), leftName);
            List<EObject> leftAssets = new ArrayList<>();
            for (JsonNode assetIdNode : leftAssetIdArrayNode) {
                String assetId = assetIdNode.asText();                    
                EObject asset = assetMap.get(assetId);
                String leftType = asset.eGet(asset.eClass().getEStructuralFeature("name")).toString();
                associationObj.eSet(associationEClass.getEStructuralFeature("leftType"), leftType);
                if (asset != null) {                       
                    leftAssets.add(asset);
                }                
            }
            associationObj.eSet(associationEClass.getEStructuralFeature("leftConnections"), leftAssets);

            // right connections
            Map.Entry<String, JsonNode> rightField = fieldsList.get(1);
            String rightName = rightField.getKey();
            JsonNode rightAssetIdArrayNode = rightField.getValue();
            associationObj.eSet(associationEClass.getEStructuralFeature("rightConnectionName"), rightName);
            List<EObject> rightAssets = new ArrayList<>();
            for (JsonNode assetIdNode : rightAssetIdArrayNode) {
                String assetId = assetIdNode.asText();
                EObject asset = assetMap.get(assetId);                       
                 String rightType = asset.eGet(asset.eClass().getEStructuralFeature("name")).toString();
                associationObj.eSet(associationEClass.getEStructuralFeature("rightType"), rightType);
                if (asset != null) {
                    rightAssets.add(asset);
                }
            }
            associationObj.eSet(associationEClass.getEStructuralFeature("rightConnections"), rightAssets);

            ((EList<EObject>) root.eGet(rootEClass.getEStructuralFeature("associations"))).add(associationObj);
        }
        
        JsonNode attackersNode = rootNode.path("attackers");
        if (attackersNode != null && attackersNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> attackers = attackersNode.fields();
            while (attackers.hasNext()) {
                Map.Entry<String, JsonNode> attackerEntry = attackers.next();
                JsonNode attackerNode = attackerEntry.getValue();
        
                JsonNode entryPointsNode = attackerNode.path("entry_points");
                List<EObject> assetList = new ArrayList<>();
                if (entryPointsNode != null && entryPointsNode.isObject()) {
                    Iterator<Map.Entry<String, JsonNode>> entryPoints = entryPointsNode.fields();
                    while (entryPoints.hasNext()) {
                        Map.Entry<String, JsonNode> entryPointEntry = entryPoints.next();
                        String assetId = entryPointEntry.getKey();
                        JsonNode entryPointNode = entryPointEntry.getValue();
                        EObject asset = assetMap.get(assetId);
                        if (asset != null) {
                            JsonNode attackStepsNode = entryPointNode.path("attack_steps");
                            if (attackStepsNode != null && attackStepsNode.isArray()) {
                                for (JsonNode attackStepNode : attackStepsNode) {
                                    EObject attackStep = factory.create(attackStepEClass);
                                    attackStep.eSet(attackStepEClass.getEStructuralFeature("name"), attackStepNode.asText());
                                    ((EList<EObject>) asset.eGet(asset.eClass().getEStructuralFeature("attackSteps"))).add(attackStep);
                                }
                            }
                        }
                    }
                }
            }
        }
        

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
}