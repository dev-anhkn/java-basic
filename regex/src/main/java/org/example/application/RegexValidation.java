package org.example.application;

public class RegexValidation {
    public static void main(String[] args) {
        String phoneNumber = "123-456-7890";
        String pattern = "\\d{3}-\\d{3}-\\d{4}"; // Mẫu cho số điện thoại

        boolean isValid = phoneNumber.matches(pattern);
        System.out.println("Phone number valid: " + isValid);
    }
}
