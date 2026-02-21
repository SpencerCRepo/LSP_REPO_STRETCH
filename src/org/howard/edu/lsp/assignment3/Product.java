package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/****
 * Represents a single product record from the CSV file.
 * Demonstrates encapsulation: all fields are private and accessed via getters/setters.
 ****/
public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private String category;

    /*****
     * Constructs a Product object with the specified details.
     *
     * @param id       The product ID
     * @param name     The product name
     * @param price    The product price
     * @param category The product category
     *****/
    public Product(int id, String name, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /*** @return The product ID */
    public int getId() { return id; }

    /*** @return The product name */
    public String getName() { return name; }

    /*** Sets the product name */
    public void setName(String name) { this.name = name; }

    /*** @return The product price */
    public BigDecimal getPrice() { return price; }

    /*** Sets the product price */
    public void setPrice(BigDecimal price) { this.price = price; }

    /*** @return The product category */
    public String getCategory() { return category; }

    /*** Sets the product category */
    public void setCategory(String category) { this.category = category; }
}