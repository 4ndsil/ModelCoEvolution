package com.coevolution;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

import com.coevolution.elements.Asset;
;

public class SolutionProcessor {

    public SolutionProcessor() {
    }

    public Model runProcessSolution(Model model, CandidateSolution solution) {
        return processSolution(model, solution);
    }

    private Model processSolution(Model model, CandidateSolution solution) {
        List<EditOperation> operations = solution.getEditOperations();

        List<Asset> assets = model.getAssets();
        Model copyModel = new Model();
        for (Asset a : assets){
            try {             
                Class<? extends Asset> assetClass = a.getClass();
                Constructor<?> cons = assetClass.getConstructor(String.class);
                Object object = cons.newInstance(a.name);
                copyModel.addAsset((Asset)object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        

        for (EditOperation op : operations) {      
                processOperation(copyModel, op);
            }
        return copyModel;
    }
            

    private void processOperation(Model model, EditOperation op) {
        if (op instanceof CreateOperation) {
            processCreateOperation(model, (CreateOperation) op);
        } else if (op instanceof DeleteOperation) {
            processDeleteOperation(model, (DeleteOperation) op);
        }
    }

    public void processCreateOperation(Model model, CreateOperation op) {
        try {
            
            Class cName = (Class) op.getAddElement();
            Class<?> c = Class.forName(cName.getCanonicalName().toString());
            Constructor<?> cons = c.getConstructor();
            Object object = cons.newInstance();          
            model.addAsset((Asset)object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processDeleteOperation(Model model, DeleteOperation op) {
        Iterator<Asset> objectIterator = model.getAssets().iterator();
        while (objectIterator.hasNext()) {
            Asset asset = objectIterator.next();
            Class<?> c = (Class) op.getDeletionElement();
            if (c.getCanonicalName().equals(asset.getClass().getCanonicalName())) {
                objectIterator.remove();
                break;
            }
        }
    }
}
