package com.coevolution;

import java.util.Comparator;
;

class EditOperationComparator implements Comparator<EditOperation> {
    @Override
    public int compare(EditOperation a, EditOperation b) {
        if (a instanceof CreateOperation && b instanceof CreateOperation) {
            CreateOperation aa = (CreateOperation) a;
            CreateOperation bb = (CreateOperation) b;
            if (aa.getAddElement().equals(bb.getAddElement())) {
                return 1;
            }        
            return 0;
        }

        if (a instanceof DeleteOperation && b instanceof DeleteOperation) {
            DeleteOperation aa = (DeleteOperation) a;
            DeleteOperation bb = (DeleteOperation) b;            
            if (aa.getDeletionElement().equals(bb.getDeletionElement())) {
                return 1;
            }            
            return 0;
        }      
        return 0;
    }
}