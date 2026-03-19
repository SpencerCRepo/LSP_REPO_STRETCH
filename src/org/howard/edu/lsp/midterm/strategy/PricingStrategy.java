package org.howard.edu.lsp.midterm.strategy;

/** Strategy for calculating price. */
public interface PricingStrategy {
    /** Calculates final price. */
    double calculatePrice(double price);
}