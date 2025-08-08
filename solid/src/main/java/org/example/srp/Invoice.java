package org.example.srp;

public record Invoice(String customerName, double amount) {

    public double calculateTax() {
        return amount * 0.1; // VAT 10%
    }

    public double getTotal() {
        return amount + calculateTax();
    }
}
