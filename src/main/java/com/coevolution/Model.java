package com.coevolution;

import java.util.ArrayList;
import java.util.List;

import com.coevolution.elements.Asset;

public class Model {
    private List<Asset> assets;

    public Model(){
        this.assets = new ArrayList<>();
    }

    public void addAsset(Asset asset){
        assets.add(asset);
    }

    public void removeAsset(Asset asset){
        assets.remove(asset);
    }

    public List<Asset> getAssets(){
        return assets;
    }
}
