
package com.coevolution;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // model instantiation        
        //ModelBuilder builder = new ModelBuilder();

       // builder.extractFile("C:\\Users\\andre\\OneDrive\\Dokument\\Skolmaterial\\24vt\\Uppsats\\Repos\\modelmigration\\src\\main\\java\\com\\coevolution\\Files.txt", 0);
        
        //Model model_1 = builder.buildModel();
        Models models = new Models();
        Model model_1 = models.model_1();
        Model metamodel_1 = models.metamodel_1();

        FitnessFunctions functions = new FitnessFunctions();
        // baseline sequence
        Edits edits = new Edits();

        List<EditOperation> model7Edits = new ArrayList<EditOperation>();

        try {
            FileWriter myWriter = new FileWriter("Result.txt.");
            int i = 0;
            long startTime = System.currentTimeMillis();
            while (i < 1) {

                NSGAII nsgaII = new NSGAII(metamodel_1, model_1, edits.edits);
                List<CandidateSolution> solutions = nsgaII.runNSGAII();
                long endTime1 = System.currentTimeMillis();
                myWriter.write("\nThat took " + (endTime1 - startTime) + " miliseconds");
                myWriter.close();
                myWriter.write("\nModel 5. Run " + i + "\n");
                CandidateSolution solution =  new CandidateSolution();
                for (EditOperation edit : solution.getEditOperations()) {
                    if (edit instanceof CreateOperation) {
                        CreateOperation createOp = (CreateOperation) edit;
                        myWriter.write("Create op " + "\n");
                        myWriter.write("Add element " + createOp.getAddElement() + "\n");                        
                    }

                    if (edit instanceof DeleteOperation) {
                        DeleteOperation deleteOp = (DeleteOperation) edit;
                        myWriter.write("Delete op " + "\n");
                        myWriter.write("Deletion element " + deleteOp.getDeletionElement() + "\n");                        
                    }                
                }
                System.out.println("Run " + i);
                i++;

                EditOperationComparator comp = new EditOperationComparator();
                int correctOPs = 0;
                for (EditOperation op : model7Edits) {
                    for (EditOperation op1 : solution.getEditOperations()) {
                        int res = comp.compare(op, op1);
                        if (res == 1) {
                            correctOPs++;
                        }
                    }
                }

                myWriter.write("\nCorrect operations: " + correctOPs + "\n");
                myWriter.write("\nNvc: " + solution.getNvc() + "\n");
                myWriter.write("\nNbOp: " + solution.getNbOp() + "\n");
                myWriter.write("\nDis: " + solution.getInconsistency() + "\n");
            }
            long endTime = System.currentTimeMillis();
            myWriter.write("\nThat took " + (endTime - startTime) + " miliseconds");
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}