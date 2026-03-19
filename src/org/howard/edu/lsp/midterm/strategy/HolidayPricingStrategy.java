package org.howard.edu.lsp.midterm.strategy;

/** Holiday customer (15% discount). */
public class HolidayPricingStrategy implements PricingStrategy {

    public double calculatePrice(double price) {
        return price * 0.85;
    }
}