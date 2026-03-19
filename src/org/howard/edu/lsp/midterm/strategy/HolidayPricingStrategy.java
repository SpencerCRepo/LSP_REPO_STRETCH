package org.howard.edu.lsp.midterm.strategy;

/** Holiday customer (15% discount). */
public class HolidayPricingStrategy implements PricingStrategy {
    /** Returns price * 0.85. */
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}