package org.example.testing;

import java.util.regex.*;

public class MetaCharacterExample {
    public static void main(String[] args) {
        // 1. Sử dụng . (bất kỳ ký tự nào ngoại trừ xuống dòng)
        System.out.println("1. . (bất kỳ ký tự nào ngoại trừ xuống dòng)");
        testRegex(".", "a");   // true
        testRegex(".", "9");   // true
        testRegex(".", "&");   // true
        testRegex(".", "\n");  // false (dấu xuống dòng)

        // 2. Sử dụng \d (chữ số) và \D (không phải chữ số)
        System.out.println("\n2. \\d (chữ số) và \\D (không phải chữ số)");
        testRegex("\\d", "5");   // true
        testRegex("\\D", "A");   // true
        testRegex("\\d", "A");   // false

        // 3. Sử dụng \w (chữ cái, số, gạch dưới) và \W (không phải \w)
        System.out.println("\n3. \\w (chữ cái, số, _) và \\W (không phải \\w)");
        testRegex("\\w", "a");   // true
        testRegex("\\w", "5");   // true
        testRegex("\\w", "_");   // true
        testRegex("\\W", "!");   // true
        testRegex("\\W", "a");   // false

        // 4. Sử dụng \s (khoảng trắng) và \S (không phải khoảng trắng)
        System.out.println("\n4. \\s (khoảng trắng) và \\S (không phải khoảng trắng)");
        testRegex("\\s", " ");   // true
        testRegex("\\s", "\t");  // true
        testRegex("\\S", "a");   // true
        testRegex("\\S", " ");   // false
    }

    public static void testRegex(String pattern, String text) {
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("Pattern: \"" + pattern + "\" | Text: \"" + text + "\" | Match: " + matches);
    }
}
