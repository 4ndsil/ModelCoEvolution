package com.coevolution;

import java.util.HashSet;
import java.util.Set;

import com.coevolution.elements.Asset;

public class FitnessFunctions {

    //Constraint constraint;

    public FitnessFunctions() {
       // this.constraint = new Constraint();

    }

    // fitness i - number of non-conformities
 public double nvc(Model metamodel, Model model) {
    Set<String> mmAssets = new HashSet<>();
    for (Asset metamodelAsset : metamodel.getAssets()) {
        mmAssets.add(metamodelAsset.getClass().getCanonicalName());
    }

    double nonConformities = 0.0;
    
    for (Asset modelAsset : model.getAssets()) {        
        if (!mmAssets.contains(modelAsset.getClass().getCanonicalName())) {
            nonConformities++;
        }
    }
    return nonConformities;
}

    // fitness ii - number of operations
    public double nbOp(CandidateSolution solution) {
        return solution.getEditOperations().size();
    }

    // fitness iii - semantic inconsistency
    public double inconsistency(Model initalModel, Model revisedModel) {
        double dotProduct = intersection(initalModel, revisedModel); // dot product
        double magnitudeInitial = Math.sqrt(getModelSize(initalModel));
        double magnitudeRevised = Math.sqrt(getModelSize(revisedModel));
        double cosineSimilarity = dotProduct / (magnitudeInitial * magnitudeRevised);

        double maxSimilarity = Math.max(magnitudeInitial, magnitudeRevised);
        double inconsistency = 1 - (cosineSimilarity / maxSimilarity);

        return inconsistency;
    }

    private double getModelSize(Model model) {
        return model.getAssets().size();
    }

    private int intersection(Model initalModel, Model revisedModel) {
        int intersection = 0;

        Set<String> mAssets = new HashSet<>();
        for (Asset mAsset : initalModel.getAssets()) {
            mAssets.add(mAsset.assetClassName);
        }
    
        for (Asset asset : revisedModel.getAssets()) {        
            if (!mAssets.contains(asset.assetClassName)) {
                intersection++;
            }
        }
        return intersection;
    }
}
