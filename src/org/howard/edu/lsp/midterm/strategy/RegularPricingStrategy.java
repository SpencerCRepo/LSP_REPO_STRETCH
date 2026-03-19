package org.howard.edu.lsp.midterm.strategy;

/** Regular customer (no discount). */
public class RegularPricingStrategy implements PricingStrategy {

    public double calculatePrice(double price) {
        return price;
    }
}