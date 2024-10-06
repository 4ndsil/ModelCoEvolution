package com.coevolution;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelLoader {
    public static Resource loadXMIModel(String fileName, EPackage ePackage) {
        ResourceSet resourceSet = new ResourceSetImpl();

        Map<String, Object> packageRegistry = resourceSet.getPackageRegistry();
        packageRegistry.put(ePackage.getNsURI(), ePackage);

        Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        Resource resource = resourceSet.getResource(URI.createURI(fileName), true);

        try {
            resource.load(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resource;
    }

     public static EPackage loadEcorePackage(String fileName) {
        ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

        Resource resource = resourceSet.getResource(URI.createURI(fileName), true);
        try {
            resource.load(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retrieve the EPackage
        if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof EPackage) {
            return (EPackage) resource.getContents().get(0);
        } else {
            return null;
        }
    }
}