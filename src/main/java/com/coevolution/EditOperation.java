package com.coevolution;

import java.util.List;

public abstract class EditOperation<Class> {
    protected String operationAssetype;

    public EditOperation(String operationAssetype) {
        this.operationAssetype = operationAssetype;        
    }
}

class CreateOperation<Class> extends EditOperation {
    private final Class addElement;    

    public CreateOperation(Class addElement) {
        super("Create");
        this.addElement = addElement;        
    }

    public Class getAddElement() {
        return addElement;
    }    
}

class DeleteOperation<Class> extends EditOperation {
    public final Class deletionElement;

    public DeleteOperation(Class deletionElement) {
        super("Delete");
        this.deletionElement = deletionElement;
    }

    public Class getDeletionElement() {
        return deletionElement;
    }
}

// RetypeOperation
class RetypeOperation<Class> extends EditOperation {
    private final Class fromAssetype;
    private final Class toAssetype;

    public RetypeOperation(Class fromAssetype, Class toAssetype) {
        super("Retype");
        this.fromAssetype = fromAssetype;
        this.toAssetype = toAssetype;
    }
}

class SplitOperation <Class> extends EditOperation {
    private Class splitElement;
    private List<Class> resultElements;

    public SplitOperation(Class splitElement, List<Class> resultElements) {
        super("Split");
        this.splitElement = splitElement;
        this.resultElements = resultElements;
    }
}
/*
class MoveOperation <Asset extends Asset> extends EditOperation<Asset> {
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
class MergeOperation extends EditOperation{
    private final List<Class> mergeElements;
    private final Class mergedElement;

    public MergeOperation(List<Class> mergeElements, Class mergedElement) {
        super("Merge");
        this.mergeElements = mergeElements;
        this.mergedElement = mergedElement;
    }
}
