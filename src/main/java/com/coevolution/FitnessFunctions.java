package com.coevolution;

import java.util.HashSet;
import java.util.Set;

import com.coevolution.elements.Asset;

public class FitnessFunctions {

    public double PENALTY_FACTOR = 2;
    private final Set<String> mmAssets = new HashSet<>();
    private final Set<String> initialAssets = new HashSet<>();

    public FitnessFunctions(Model metamodel, Model model) {        
        for (Asset metamodelAsset : metamodel.getAssets()) {
            mmAssets.add(metamodelAsset.getClass().getCanonicalName());
        }
        
        for (Asset mAsset : model.getAssets()) {
            initialAssets.add(mAsset.assetClassName);
        }
    }

    // fitness i - number of non-conformities
 public double nvc(Model metamodel, Model model) {
    double nonConformities = 0.0;
    
    for (Asset modelAsset : model.getAssets()) {        
        if (!mmAssets.contains(modelAsset.getClass().getCanonicalName())) {
            nonConformities++;
        }
    }
    return nonConformities;
}
/*
    // fitness ii - number of operations
    public double nbOp(CandidateSolution solution) {
        return solution.getEditOperations().size() * PENALTY_FACTOR;
    }
 */
    // fitness iii - semantic inconsistency
    public double inconsistency(Model initialModel, Model revisedModel) {
   
        double dotProduct = intersection(revisedModel); // dot product
        double magnitudeInitial = Math.sqrt(getModelSize(initialModel));
        double magnitudeRevised = Math.sqrt(getModelSize(revisedModel));
        double cosineSimilarity = dotProduct / (magnitudeInitial * magnitudeRevised);

        double maxSimilarity = Math.max(magnitudeInitial, magnitudeRevised);
        double inconsistency = 1 - (cosineSimilarity / maxSimilarity);

        return inconsistency;
        
    }

    private double getModelSize(Model model) {
        return model.getAssets().size();
    }

    private int intersection(Model revisedModel) {
        int intersection = 0;
    
        for (Asset asset : revisedModel.getAssets()) {        
            if (initialAssets.contains(asset.assetClassName)) {
                intersection++;
            }
        }
        return intersection;
    }
}
