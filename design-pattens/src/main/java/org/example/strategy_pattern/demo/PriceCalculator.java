package org.example.strategy_pattern.demo;

import java.util.HashMap;
import java.util.Map;

public class PriceCalculator {

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

    private final Map<String, PromotionStrategy> strategies = new HashMap<>();

    {
        strategies.put("preorder", new PreOrderStrategy());
        strategies.put("promotion", new PromotionStrategyImpl());
        strategies.put("blackfriday", new BlackFridayStrategy());
        strategies.put("default", new NoDiscountStrategy());
    }

    public double calculatePrice(double originalPrice, String promotionType) {
        PromotionStrategy strategy = strategies.getOrDefault(promotionType, strategies.get("default"));
        return strategy.applyDiscount(originalPrice);
    }

    public interface PromotionStrategy {
        double applyDiscount(double originalPrice);
    }

    public static class PreOrderStrategy implements PromotionStrategy {
        public double applyDiscount(double originalPrice) {
            return originalPrice * 0.9;
        }
    }

    public static class PromotionStrategyImpl implements PromotionStrategy {
        public double applyDiscount(double originalPrice) {
            return originalPrice * 0.8;
        }
    }

    public static class BlackFridayStrategy implements PromotionStrategy {
        public double applyDiscount(double originalPrice) {
            return originalPrice * 0.1;
        }
    }

    public static class NoDiscountStrategy implements PromotionStrategy {
        public double applyDiscount(double originalPrice) {
            return originalPrice;
        }
    }
}