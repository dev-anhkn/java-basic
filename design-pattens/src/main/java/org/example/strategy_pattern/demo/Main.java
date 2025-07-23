package org.example.strategy_pattern.demo;

public class Main {

    public static double getPrice(double originalPrice, String promotionType) {
        if ("preorder".equals(promotionType)) {
            return originalPrice * 0.9;
        } else if ("promotion".equals(promotionType)) {
            return originalPrice * 0.8;
        } else if ("blackfriday".equals(promotionType)) {
            return originalPrice * 0.1;
        } else {
            return originalPrice;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPrice(1000, "preorder"));

        // --------------------
        PriceCalculator calculator = new PriceCalculator();

        System.out.println("PreOrder: " + calculator.calculatePrice(1000, "preorder"));       // 900.0
        System.out.println("Promotion: " + calculator.calculatePrice(1000, "promotion"));     // 800.0
        System.out.println("BlackFriday: " + calculator.calculatePrice(1000, "blackfriday")); // 100.0
        System.out.println("No promo: " + calculator.calculatePrice(1000, "unknown"));        // 1000.0
    }
}