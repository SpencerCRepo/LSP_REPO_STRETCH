package org.howard.edu.lsp.midterm.strategy;

/** Regular customer (no discount). */
public class RegularPricingStrategy implements PricingStrategy {
    /** Returns original price. */
    public double calculatePrice(double price) {
        return price;
    }
}