package com.coevolution;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.helper.OCLHelper;

public class OCLHelperUtil {

    private static final OCL OCL_INSTANCE = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

    public static OCLHelper<EClassifier, ?, ?, ?> createHelper(EPackage ePackage, String contextString) {
        EClassifier context = ePackage.getEClassifier(contextString);
        OCLHelper<EClassifier, ?, ?, ?> helper = OCL_INSTANCE.createOCLHelper();
        helper.setContext(context);
        return helper;
    }

    public static OCL getOCLInstance() {
        return OCL_INSTANCE;
    }
}

