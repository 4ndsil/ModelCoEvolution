package com.coevolution;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public abstract class RepairOperation {
    protected String operationAssetype;

    public RepairOperation(String operationAssetype) {
        this.operationAssetype = operationAssetype;        
    }
}

class CreateOperation extends RepairOperation {
    private final EObject createElement;
    private final EObject targetElement;

    public CreateOperation(EObject createElement, EObject targetElement) {
        super("Create");
        this.createElement = createElement;
        this.targetElement = targetElement;    
    }

    public EObject getCreateElement() {
        return createElement;
    }

    public EObject getTargetElement() {
        return targetElement;
    }
}

class DeleteOperation extends RepairOperation {
    public final EObject deleteElement;
    public final EObject targetElement;

    public DeleteOperation(EObject deleteElement, EObject targetElement) {
        super("Delete");
        this.deleteElement = deleteElement;
        this.targetElement = targetElement;
    }

    public EObject getDeleteElement() {
        return deleteElement;
    }

    public EObject getTargetElement() {
        return targetElement;
    }
}

// RetypeOperation
class RetypeOperation extends RepairOperation {
    private final EObject newType;
    private final EObject targetElement;

    public RetypeOperation(EObject newType, EObject targetElement) {
        super("Retype");        
        this.newType = newType;
        this.targetElement = targetElement;
    }

    public EObject getNewType() {
        return newType;
    }

    public EObject getTargetElement() {
        return targetElement;
    }
}


class SplitOperation extends RepairOperation {
    private EObject splitElement;
    private List<EObject> resultElements;

    public SplitOperation(EObject splitElement, List<EObject> resultElements) {
        super("Split");
        this.splitElement = splitElement;
        this.resultElements = resultElements;
    }
}
/*
class MoveOperation <Asset extends Asset> extends RepairOperation<Asset> {
    public final Asset fromElement;
    public final Asset targetElement;
    public final Asset moveElement;

    public MoveOperation(Asset moveElement, Asset fromElement, Asset targetElement) {
        super("Move");
        this.moveElement = moveElement;
        this.fromElement = fromElement;
        this.targetElement = targetElement;
    }

    public Asset getFromElement() {
        return fromElement;
    }

    public Asset getAssetargetElement() {
        return targetElement;
    }

    public Asset getMoveElement() {
        return moveElement;
    }
}
 */
class MergeOperation extends RepairOperation{
    private final List<EObject> mergeElements;
    private final EObject mergedElement;

    public MergeOperation(List<EObject> mergeElements, EObject mergedElement) {
        super("Merge");
        this.mergeElements = mergeElements;
        this.mergedElement = mergedElement;
    }
}
