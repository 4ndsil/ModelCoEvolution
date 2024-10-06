package com.coevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class MetamodelUtils {
    public static List<EObject> getAllAssets(Resource metamodel) {
        List<EObject> assets = new ArrayList<>();
        for (EObject eObject : metamodel.getContents()) {
            findAllAssets(eObject, assets);
        }
        return assets;
    }
    
    private static void findAllAssets(EObject eObject, List<EObject> assets) {
        if (eObject.eClass().getName().equals("Asset")) {
            assets.add(eObject);
        }
        for (EObject child : eObject.eContents()) {
            findAllAssets(child, assets);
        }
    }

  public static EObject getAssetByType(Resource metamodel, String assetType) {
        for (EObject eObject : metamodel.getContents()) {
            EObject foundAsset = findAsset(eObject, assetType);
            if (foundAsset != null) {
                return foundAsset;
            }
        }
        return null;
    }

    private static EObject findAsset(EObject eObject, String assetType) {
        if (eObject.eClass().getName().equals("Asset")) {
            if (eObject.eGet(eObject.eClass().getEStructuralFeature("name")).toString().equals(assetType)) {
                return eObject;
            }
        }

        for (EObject child : eObject.eContents()) {
            EObject foundAsset = findAsset(child, assetType);
            if (foundAsset != null) {
                return foundAsset; 
            }
        }

        return null; 
    }


    public static EObject getRandomAsset(Resource metamodel) {
        Random rand = new Random();        
        List<EObject> objs = getAllAssets(metamodel);
        int randInt = rand.nextInt(objs.size());        
        return objs.get(randInt);
    }

    public static String getRandomAssetString(Resource metamodel) {
        EObject obj = getRandomAsset(metamodel);
        String assetName = obj.eGet(obj.eClass().getEStructuralFeature("name")).toString();
        return assetName;
    }

    public static List<EObject> getAllAttackStepsFromAsset(EObject asset) {
        List<EObject> objs = new ArrayList<>();
        for (EObject eObject : (List<EObject>) asset.eGet(asset.eClass().getEStructuralFeature("attackSteps"))) {
            findAllAttackSteps(eObject, objs);
        }
        return objs;
    }

     public static List<EObject> getAllAttackSteps(Resource metamodel) {
        List<EObject> objs = new ArrayList<>();
        for (EObject eObject : metamodel.getContents()) {
            findAllAttackSteps(eObject, objs);
        }
        return objs;
    }
    
    private static void findAllAttackSteps(EObject eObject, List<EObject> objs) {
        if (eObject.eClass().getName().equals("AttackStep")) {
            objs.add(eObject);
        }
        for (EObject child : eObject.eContents()) {
            findAllAttackSteps(child, objs);
        }
    }

    public static EObject getRandomAttackStep(Resource metamodel) {
        Random rand = new Random();        
        List<EObject> objs = getAllAttackSteps(metamodel);
        int randInt = rand.nextInt(objs.size());
        return objs.get(randInt);
    }

    public static List<EObject> getAllAssociations(Resource metamodel) {
        List<EObject> objs = new ArrayList<>();
        for (EObject eObject : metamodel.getContents()) {
            findAllAssociations(eObject, objs);
        }
        return objs;
    }
    
    private static void findAllAssociations(EObject eObject, List<EObject> objs) {
        if (eObject.eClass().getName().equals("Association")) {
            objs.add(eObject);
        }
        for (EObject child : eObject.eContents()) {
            findAllAssociations(child, objs);
        }
    }

    public static EObject getRandomAssociation(Resource metamodel) {
        Random rand = new Random();        
        List<EObject> objs = getAllAssociations(metamodel);
        int randInt = rand.nextInt(objs.size());        
        return objs.get(randInt);
    }
}
