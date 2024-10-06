package com.coevolution;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class SolutionProcessor {


    public static Resource runProcessSolution(Resource model, CandidateSolution solution) {
        return processSolution(model, solution);
    }

    private static Resource processSolution(Resource model, CandidateSolution solution) {
        List<RepairOperation> operations = solution.getRepairOperations();
        for (RepairOperation op : operations) {
            processOperation(model, op);
        }

        return model;
    }

    public static Resource copyModel(Resource model) {
        EcoreUtil.Copier copier = new EcoreUtil.Copier();

        URI newURI = model.getURI().trimFileExtension().appendSegment("_copy").appendFileExtension(model.getURI().fileExtension());
        
        Resource copyModel = model.getResourceSet().createResource(newURI);

        copier.copy(model.getContents().get(0));

        copier.copyReferences();

        copyModel.getContents().addAll(copier.values());

        try {           
            copyModel.save(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return copyModel;
    }

    private static void processOperation(Resource model, RepairOperation op) {
        if (op instanceof CreateOperation) {
            processCreateOperation(model, (CreateOperation) op);
        } else if (op instanceof DeleteOperation) {
            processDeleteOperation(model, (DeleteOperation) op);
        } else if (op instanceof RetypeOperation) {
            processRetypeOperation(model, (RetypeOperation) op);
        }
    }

    private static void processCreateOperation(Resource model, CreateOperation op) {
        EObject obj = op.getCreateElement();
        EObject targetObj = findEObjectInResource(model, op.getTargetElement());
        if (targetObj.eClass().getName().equals("Root") && obj.eClass().getName().equals("Asset")){
            ((EList<EObject>) targetObj.eGet(targetObj.eClass().getEStructuralFeature("assets"))).add(obj);
        }
        if (targetObj.eClass().getName().equals("Asset")){
            ((EList<EObject>) targetObj.eGet(targetObj.eClass().getEStructuralFeature("attackSteps"))).add(obj);
        }
        if (targetObj.eClass().getName().equals("Root")&& obj.eClass().getName().equals("Association")){
            ((EList<EObject>) targetObj.eGet(targetObj.eClass().getEStructuralFeature("associations"))).add(obj);
        }    
    }
    
    private static void processDeleteOperation(Resource model, DeleteOperation op) {     
        if (!op.getTargetElement().eClass().getName().equals("Root")){
            List<EObject> assets = (List<EObject>) model.getContents().get(0).eGet(model.getContents().get(0).eClass().getEStructuralFeature("assets"));
            Iterator<EObject> objs = assets.iterator();
              while (objs.hasNext()) {
                EObject obj = objs.next();
                if (obj.eGet(obj.eClass().getEStructuralFeature("eid")).equals(op.getTargetElement().eGet(op.getTargetElement().eClass().getEStructuralFeature("eid")))) {
                    Iterator<EObject> objContents = obj.eContents().iterator();
                    
                    while (objContents.hasNext()) {
                        EObject objContent = objContents.next();
                        if (objContent.eGet(objContent.eClass().getEStructuralFeature("name")).equals(op.getDeleteElement().eGet(op.getDeleteElement().eClass().getEStructuralFeature("name")))) {                      
                            EStructuralFeature containingFeature = objContent.eContainingFeature();
                            if (containingFeature != null) {
                                ((EList<EObject>) obj.eGet(containingFeature)).remove(objContent);
                            }
                            break;
                        }   
                    }
                }
            }
        }
        model.getContents().remove(op.getDeleteElement());
    }


    private static void processRetypeOperation(Resource model, RetypeOperation op) {
        EObject obj = op.getTargetElement();
        EObject newType = op.getNewType();

        EcoreUtil.replace(obj, newType);
    }

    private static EObject findEObjectInResource(Resource model, EObject targetObj) {
        for (EObject eObject : model.getContents()) {
            if (targetObj.eClass().getName().equals("Root")) {
                return eObject;
            } else {
                List<EObject> assets = (List<EObject>) eObject.eGet(eObject.eClass().getEStructuralFeature("assets"));
                for (EObject child : assets) {
                    String childId = child.eGet(child.eClass().getEStructuralFeature("eid")).toString();
                    String targetId = targetObj.eGet(targetObj.eClass().getEStructuralFeature("eid")).toString();
                    if (childId.equals(targetId)) {
                        return child;
                    }
                }
            }
        }
        return targetObj;
    }
}