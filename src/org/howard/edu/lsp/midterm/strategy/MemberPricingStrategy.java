package org.howard.edu.lsp.midterm.strategy;

/** Member customer (10% discount). */
public class MemberPricingStrategy implements PricingStrategy {
    /** Returns price * 0.90. */
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}