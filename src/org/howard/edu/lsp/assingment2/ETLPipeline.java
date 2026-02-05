package org.howard.edu.lsp.assingment2;


import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {

    private static final String DEFAULT_INPUT  = "data/products.csv";
    private static final String DEFAULT_OUTPUT = "data/transformed_products.csv";

    public static void main(String[] args) {

        String inputFile  = args.length > 0 ? args[0] : DEFAULT_INPUT;
        String outputFile = args.length > 1 ? args[1] : DEFAULT_OUTPUT;

        ETLResult result = runPipeline(inputFile, outputFile);

        System.out.println("Rows read: "        + result.rowsRead);
        System.out.println("Rows transformed: " + result.rowsGood);
        System.out.println("Rows skipped: "     + result.rowsSkipped);
        System.out.println("Output file: "      + outputFile);
    }

    private static ETLResult runPipeline(String input, String output) {

        int read = 0, good = 0, skipped = 0;
        List<String> outputLines = new ArrayList<>();

        outputLines.add("ProductID,Name,Price,Category,PriceRange");

        File file = new File(input);
        if (!file.exists()) {
            System.out.println("Error: Input file " + input + " does not exist.");
            return new ETLResult(0, 0, 0);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                read++;

                String transformed = transformLine(line);
                if (transformed == null) {
                    skipped++;
                } else {
                    outputLines.add(transformed);
                    good++;
                }
            }

        } catch (IOException e) {
            System.out.println("File reading problem: " + e.getMessage());
        }

        writeOutput(output, outputLines);
        return new ETLResult(read, good, skipped);
    }

    private static String transformLine(String line) {

        line = line.trim();
        if (line.isEmpty()) return null;

        String[] p = line.split(",");
        if (p.length != 4) return null;

        for (int i = 0; i < p.length; i++) {
            p[i] = p[i].trim();
        }

        int id;
        BigDecimal price;

        try {
            id = Integer.parseInt(p[0]);
            price = new BigDecimal(p[2]);
        } catch (Exception e) {
            return null;
        }

        String name = p[1].toUpperCase();
        String category = p[3];

        if (category.equals("Electronics")) {
            price = price.multiply(new BigDecimal("0.9"));
        }

        BigDecimal finalPrice = price.setScale(2, RoundingMode.HALF_UP);

        if (category.equals("Electronics")
                && finalPrice.compareTo(new BigDecimal("500")) > 0) {
            category = "Premium Electronics";
        }

        String priceRange = getPriceRange(finalPrice);

        return id + "," +
                name + "," +
                finalPrice.toPlainString() + "," +
                category + "," +
                priceRange;
    }

    private static String getPriceRange(BigDecimal price) {

        if (price.compareTo(new BigDecimal("10")) <= 0) {
            return "Low";
        } else if (price.compareTo(new BigDecimal("100")) <= 0) {
            return "Medium";
        } else if (price.compareTo(new BigDecimal("500")) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }

    private static void writeOutput(String output, List<String> lines) {

        try (PrintWriter pw = new PrintWriter(output)) {
            for (String line : lines) {
                pw.println(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot write output file");
        }
    }

    private static class ETLResult {
        int rowsRead;
        int rowsGood;
        int rowsSkipped;

        ETLResult(int r, int g, int s) {
            rowsRead = r;
            rowsGood = g;
            rowsSkipped = s;
        }
    }
}
