package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the ETL process for products.
 * Reads products from a CSV file, transforms them according to business rules,
 * and writes the results to an output CSV file.
 */
public class ETLPipeline {

    /**
     * Runs the ETL pipeline on the given input file and writes to the given output file.
     *
     * @param inputFile  The path to the input CSV file
     * @param outputFile The path to the output CSV file
     */
    public void run(String inputFile, String outputFile) {

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        List<String> outputLines = new ArrayList<>();
        outputLines.add("ProductID,Name,Price,Category,PriceRange");

        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Error: Input file does not exist.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                rowsRead++;

                Product product = parseProduct(line);

                if (product == null) {
                    rowsSkipped++;
                    continue;
                }

                String priceRange = transformProduct(product);

                outputLines.add(
                        product.getId() + "," +
                                product.getName() + "," +
                                product.getPrice().toPlainString() + "," +
                                product.getCategory() + "," +
                                priceRange
                );

                rowsTransformed++;
            }

        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }

        writeOutput(outputFile, outputLines);

        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + outputFile);
    }

    /**
     * Parses a line from the CSV file into a Product object.
     *
     * @param line A single line from the CSV
     * @return A Product object, or null if the line is invalid
     */
    private Product parseProduct(String line) {

        line = line.trim();
        if (line.isEmpty()) return null;

        String[] parts = line.split(",");
        if (parts.length != 4) return null;

        try {
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            BigDecimal price = new BigDecimal(parts[2].trim());
            String category = parts[3].trim();

            return new Product(id, name, price, category);

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Applies the transformation rules to a Product object.
     *
     * @param product The product to transform
     * @return The price range of the product after transformation
     */
    private String transformProduct(Product product) {

        product.setName(product.getName().toUpperCase());

        BigDecimal price = product.getPrice();
        String category = product.getCategory();

        if (category.equals("Electronics")) {
            price = price.multiply(new BigDecimal("0.9"));
        }

        BigDecimal finalPrice = price.setScale(2, RoundingMode.HALF_UP);

        if (category.equals("Electronics") &&
                finalPrice.compareTo(new BigDecimal("500")) > 0) {
            category = "Premium Electronics";
        }

        product.setPrice(finalPrice);
        product.setCategory(category);

        if (finalPrice.compareTo(new BigDecimal("10")) <= 0)
            return "Low";
        else if (finalPrice.compareTo(new BigDecimal("100")) <= 0)
            return "Medium";
        else if (finalPrice.compareTo(new BigDecimal("500")) <= 0)
            return "High";
        else
            return "Premium";
    }

    /**
     * Writes the output lines to the specified CSV file.
     *
     * @param outputFile The output file path
     * @param lines      The lines to write
     */
    private void writeOutput(String outputFile, List<String> lines) {
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            for (String line : lines) {
                pw.println(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot write output file.");
        }
    }
}