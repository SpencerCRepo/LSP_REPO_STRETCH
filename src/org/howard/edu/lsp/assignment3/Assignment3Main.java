package org.howard.edu.lsp.assignment3;

/**
 * Runs the ETL pipeline on the specified input and output files.
 */
public class Assignment3Main {


    public static void main(String[] args) {

        String inputFile = args.length > 0 ? args[0] : "data/products.csv";
        String outputFile = args.length > 1 ? args[1] : "data/transformed_products.csv";

        ETLPipeline pipeline = new ETLPipeline();
        pipeline.run(inputFile, outputFile);
    }
}