package com.malecorebuilder;

import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Main{
    public static void main(String[] args){        
        EcorePackage.eINSTANCE.eClass();
        EPackage ePackage = EcoreMetamodelBuilder.buildEcoreMetamodel();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        reg.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        
        try {
            EcoreMetamodelPopulator.populateModel(ePackage, "coreLang_1.0.0.json", "app_metamodel.xmi");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            EcoreModelPopulator.populateModel(ePackage, "app_model.json", "app_model.xmi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
