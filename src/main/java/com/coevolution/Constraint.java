package com.coevolution;

import java.util.*;

import com.coevolution.elements.Asset;
/*
class Constraint {    

    public Constraint() {        
    }

    public boolean checkConstraints(Asset model, Asset asset) {                    
          if (model.getClass())
    }
    
} 
/*
 * public boolean checkConstraints(EditOperation op) {
 * if (op instanceof CreateOperation) {
 * CreateOperation createOp = (CreateOperation) op;
 * String targetElement = createOp.getTargetElement();
 * String[] targetTokens = targetElement.split("\\s+");
 * String addElement = createOp.getAddElement();
 * String[] addTokens = addElement.split("\\s+");
 * if (createOp.elementType == "object") {
 * if (!correspondingObjectExists(targetElement, addTokens)) {
 * return false;
 * }
 * }
 * if (createOp.elementType == "slot") {
 * if (!correspondingSlotExists(targetTokens, addElement)) {
 * return false;
 * }
 * }
 * if (createOp.elementType == "link") {
 * if (!correspondingLinkExists(targetElement, addElement)) {
 * return false;
 * }
 * }
 * }
 * 
 * return true;
 * 
 * }
 * 
 * private boolean correspondingObjectExists(String targetElement, String[]
 * elements) {
 * boolean bool = false;
 * if (metamodel.hasObject(targetElement))
 * bool = true;
 * if (metamodel.hasSlot(elements[1], elements[0]))
 * bool = true;
 * return bool;
 * }
 * 
 * private boolean correspondingSlotExists(String[] targetTokens, String
 * element) {
 * boolean bool = false;
 * if (targetTokens.length < 2) {
 * }
 * 
 * if (metamodel.hasSlot(targetTokens[1], targetTokens[0]))
 * bool = true;
 * Slot slot = metamodel.getSlot(targetTokens[1], targetTokens[0]);
 * if (slot != null) {
 * slot.hasConnectedSlot(element);
 * bool = true;
 * }
 * return bool;
 * }
 * 
 * private boolean correspondingLinkExists(String targetElement, String element)
 * {
 * boolean bool = false;
 * if (metamodel.hasLink(targetElement))
 * bool = true;
 * if (metamodel.hasLink(element))
 * bool = true;
 * return bool;
 * }
 * }
 * 
 */