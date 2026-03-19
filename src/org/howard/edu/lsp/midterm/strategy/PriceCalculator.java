package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a PricingStrategy (Strategy Pattern).
 */
public class PriceCalculator {
    private PricingStrategy strategy;



    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the current strategy.
     * @param price the original purchase price
     * @return the discounted/final price
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            throw new IllegalStateException("No pricing strategy has been set");
        }
        return strategy.calculatePrice(price);
    }
}