package com.coevolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.coevolution.OCLModelValidator.BrokenConstraint;

public class RepairOperationGenerator {


    private static Set<String> triedCombinations = new HashSet<>();

    public static List<RepairOperation> getUniqueRepairSequence(Resource metamodel, List<BrokenConstraint> brokenConstraints) {
        Map<String, List<RepairOperation>> operationsMap = generateRepairOperations(metamodel, brokenConstraints);
        List<RepairOperation> sequence;

        do {
            sequence = generateRepairSequence(operationsMap, brokenConstraints);
        } while (isCombinationTried(sequence));

        addCombination(sequence);

        return sequence;
    }

    private static List<RepairOperation> generateRepairSequence(Map<String, List<RepairOperation>> operationsMap, List<BrokenConstraint> brokenConstraints) {
        List<RepairOperation> sequence = new ArrayList<>();
        Random rand = new Random();
        List<RepairOperation> operationsAll = new ArrayList<>();
        for (BrokenConstraint brokenConstraint : brokenConstraints) {
            String con = brokenConstraint.getConstraint();
            List<RepairOperation> operations = operationsMap.get(con);
            operationsAll.addAll(operations);
        }
        for (int i = 0; i < brokenConstraints.size(); i++){
            int operationIndex = rand.nextInt(operationsAll.size());
            sequence.add(operationsAll.get(operationIndex));
        }
        sequence = sequence.stream().distinct().collect(Collectors.toList());

        return sequence;
    }

    private static boolean isCombinationTried(List<RepairOperation> sequence) {
        String combinationKey = createCombinationKey(sequence);
        return triedCombinations.contains(combinationKey);
    }

    private static void addCombination(List<RepairOperation> sequence) {
        String combinationKey = createCombinationKey(sequence);
        triedCombinations.add(combinationKey);
    }

    private static String createCombinationKey(List<RepairOperation> sequence) {
        return sequence.stream()
                       .map(RepairOperation::toString)
                       .collect(Collectors.joining(","));
    }

    public static List<RepairOperation> getAllRepairOperations(Resource metamodel, List<BrokenConstraint> brokenConstraints){
        Map<String, List<RepairOperation>> operationsMap = generateRepairOperations(metamodel, brokenConstraints);
        return operationsMap.values().stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    private static Map<String, List<RepairOperation>> generateRepairOperations(Resource metamodel, List<BrokenConstraint> brokenConstraints) {
        Map<String, List<RepairOperation>> categorizedOperations = new HashMap<>();
        for (BrokenConstraint brokenConstraint : brokenConstraints) {
            String constraints = brokenConstraint.getConstraint();

            if (constraints.contains("O1")) {
                List<RepairOperation> temp = new ArrayList<>();
                temp.addAll(repairO1_1(metamodel, brokenConstraint.getObject()));
                temp.addAll(repairO1_2(brokenConstraint.getObject()));
                addOperations(categorizedOperations,"O1", temp);
            }

            if (constraints.contains("O2")) {
                List<RepairOperation> temp = new ArrayList<>();      
                addOperations(categorizedOperations,"O2", temp);
            }

            if (constraints.contains("V1")) {
                List<RepairOperation> temp = new ArrayList<>();
                temp.addAll(repairV1_1(metamodel, brokenConstraint.getObject()));  
                temp.addAll(repairV1_2(brokenConstraint.getObject()));                
                addOperations(categorizedOperations,"V1", temp);
            }

            if (constraints.contains("L1")) {
                List<RepairOperation> temp = new ArrayList<>();
                temp.addAll(repairL1_1(metamodel, brokenConstraint.getObject()));  
                temp.addAll(repairL1_2(metamodel, brokenConstraint.getObject())); 
                addOperations(categorizedOperations, "L1", temp);
            }
        }

        return categorizedOperations;
    }

    private static void addOperations(Map<String, List<RepairOperation>> categorizedOperations, String identifier, List<RepairOperation> ops) {
        if (!categorizedOperations.containsKey(identifier)) {
            categorizedOperations.put(identifier, new ArrayList<>());
        }
        categorizedOperations.get(identifier).addAll(ops);
    }

    // assets

    private static List<RepairOperation> repairO1_1(Resource metamodel, EObject brokenConstraint) {
        List<RepairOperation> ops = new ArrayList<>();
        List<EObject> newObjs = MetamodelUtils.getAllAssets(metamodel);
        for (EObject newObj : newObjs) {
            ops.add(new RetypeOperation(newObj, brokenConstraint));
        }
        return ops;
    }

    private static List<RepairOperation> repairO1_2(EObject brokenConstraint) {
        List<RepairOperation> ops = new ArrayList<>();
        EObject target = brokenConstraint.eContainer();
        ops.add(new DeleteOperation(brokenConstraint, target));
        return ops;
    }

    // attackSteps
    private static List<RepairOperation> repairV1_1(Resource metamodel, EObject brokenConstraint) {
        List<RepairOperation> ops = new ArrayList<>();
        EObject targetAsset = brokenConstraint.eContainer();
        EObject asset = MetamodelUtils.getAssetByType(metamodel, targetAsset.eGet(targetAsset.eClass().getEStructuralFeature("name")).toString());
        List<EObject> attrsMM = MetamodelUtils.getAllAttackStepsFromAsset(asset);
        for (EObject attrMM : attrsMM) {
            EObject target = brokenConstraint.eContainer();
            ops.add(new CreateOperation(attrMM, target));
        }
        return ops;
    }

    private static List<RepairOperation> repairV1_2(EObject brokenConstraint) {
        List<RepairOperation> ops = new ArrayList<>();
        EObject target = brokenConstraint.eContainer();
        ops.add(new DeleteOperation(brokenConstraint, target));
        return ops;
    }

    // associations
    private static List<RepairOperation> repairL1_1(Resource metamodel, EObject brokenConstraint) {
        List<RepairOperation> ops = new ArrayList<>();
        List<EObject> objs = MetamodelUtils.getAllAssociations(metamodel);
        String leftAsset = (String) brokenConstraint.eGet(brokenConstraint.eClass().getEStructuralFeature("leftType"));
        String rightAsset = (String) brokenConstraint.eGet(brokenConstraint.eClass().getEStructuralFeature("rightType"));
        for (EObject objMM : objs){
            String leftAssetMM = (String) objMM.eGet(objMM.eClass().getEStructuralFeature("leftType"));
            String rightAssetMM = (String) objMM.eGet(objMM.eClass().getEStructuralFeature("rightType"));
            if (leftAsset.equals(leftAssetMM) && rightAsset.equals(rightAssetMM)){
                EObject target = brokenConstraint.eContainer();
                ops.add(new CreateOperation(objMM, target));
            }
        }
        return ops;
    }

    private static List<RepairOperation> repairL1_2(Resource metamodel, EObject brokenConstraint) {
        List<RepairOperation> ops = new ArrayList<>();
        EObject target = brokenConstraint.eContainer();
        ops.add(new DeleteOperation(brokenConstraint, target));
        return ops;
    }

    // association retype
    private static List<RepairOperation> repairL1_4(Resource metamodel, EObject brokenConstraint){
        List<RepairOperation> ops = new ArrayList<>();
        EObject association = MetamodelUtils.getRandomAssociation(metamodel);
        ops.add(new RetypeOperation(association, brokenConstraint));
        return ops;     
    }
}