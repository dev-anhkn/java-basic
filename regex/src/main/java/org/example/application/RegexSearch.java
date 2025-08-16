package org.example.application;

import java.util.regex.*;

public class RegexSearch {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com or admin@example.com";
        String regex = "\\b[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}\\b"; // Mẫu cho địa chỉ email

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found email: " + matcher.group());
        }
    }
}
