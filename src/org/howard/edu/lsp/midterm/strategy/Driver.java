package org.howard.edu.lsp.midterm.strategy;

public class Driver {
    public static void main(String[] args) {
        PriceCalculator calc = new PriceCalculator();
        double price = 100.0;

        calc.setStrategy(new RegularPricingStrategy());
        System.out.println("REGULAR: " + calc.calculatePrice(price));

        calc.setStrategy(new MemberPricingStrategy());
        System.out.println("MEMBER: " + calc.calculatePrice(price));

        calc.setStrategy(new VIPPricingStrategy());
        System.out.println("VIP: " + calc.calculatePrice(price));

        calc.setStrategy(new HolidayPricingStrategy());
        System.out.println("HOLIDAY: " + calc.calculatePrice(price));
    }
}