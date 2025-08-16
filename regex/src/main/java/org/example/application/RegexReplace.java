package org.example.application;

public class RegexReplace {
    public static void main(String[] args) {
        String text = "The price is 1000; the discount is 200;";
        String pattern = ";";
        String replacement = ",";

        String result = text.replaceAll(pattern, replacement);
        System.out.println("Updated text: " + result);
    }
}
