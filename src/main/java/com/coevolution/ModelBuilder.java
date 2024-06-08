package com.coevolution;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import com.coevolution.elements.Asset;

public class ModelBuilder {

   ArrayList<String> fileContent;
   Pattern pattern;

   public ModelBuilder(){
        this.pattern = Pattern.compile("public\\s+class\\s+(\\w+)\\s*");
   }
    
    public void extractFile(String stringPath, int index) {

        this.fileContent = new ArrayList<String>();

        Path path = Paths.get(stringPath);
        ArrayList<String> filePaths = new ArrayList<String>();

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(line -> filePaths.add(line));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String filePath = filePaths.get(index);
        try {
            fileContent.add(Files.readString(Path.of(filePath)));
        } catch (IOException e) {
            System.out.println("fel");
        }
    } 

     public Model buildModel() {
        List<Asset> assets = extractAssetsFromTest();

        Model model = new Model();

        for (Asset asset : assets) {
            model.addAsset(asset);
        }

        return model;
    }

    private List<Asset> extractAssetsFromTest() {
        List<Asset> assets = new ArrayList<>();
        try {
               String className = "";                        

                for (String content : fileContent) {
                    Matcher matcher = pattern.matcher(content);
                    if (matcher.find()){
                       className = matcher.group(1);
                    }
                }

                Class<?> testClass = Class.forName(className);
            
                Object testInstance = testClass.getDeclaredConstructor().newInstance();
            
                for (Class<?> innerClass : testClass.getDeclaredClasses()) {                
                    if (innerClass.getSimpleName().endsWith("Model")) {                
                        Object modelInstance = innerClass.getDeclaredConstructor(testClass).newInstance(testInstance);
                        
                        for (Field field : innerClass.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object value = field.get(modelInstance);
                                                    
                            if (value instanceof Asset) {
                                assets.add((Asset) value);
                            }
                        }
                    }
                }
        } catch (Exception e) {
                e.printStackTrace();
        }

        return assets;
    }

    public static void main(String[] args) {
        ModelBuilder builder = new ModelBuilder();
        builder.buildModel();
    }
}


