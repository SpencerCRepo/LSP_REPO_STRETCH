package org.howard.edu.lsp.midterm.strategy;

/** VIP customer (20% discount). */
public class VIPPricingStrategy implements PricingStrategy {
    /** Returns price * 0.80. */
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}