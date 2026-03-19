package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {

    public double calculatePrice(String customerType, double price) {

        double finalPrice = price;

        if (customerType.equals("REGULAR")) {
            finalPrice = price;
        }
        if (customerType.equals("MEMBER")) {
            finalPrice = price * 0.90;
        }
        if (customerType.equals("VIP")) {
            finalPrice = price * 0.80;
        }
        if (customerType.equals("HOLIDAY")) {
            finalPrice = price * 0.85;
        }

        return finalPrice;
    }
}