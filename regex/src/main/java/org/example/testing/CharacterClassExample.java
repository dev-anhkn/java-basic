package org.example.testing;

import java.util.regex.*;

public class CharacterClassExample {
    public static void main(String[] args) {
        // 1. [abc] → Chỉ chứa "a", "b" hoặc "c"
        System.out.println("1. [abc] → Chỉ chứa 'a', 'b' hoặc 'c'");
        testRegex("[abc]", "a");  // true
        testRegex("[abc]", "b");  // true
        testRegex("[abc]", "d");  // false

        // 2. [^abc] → Không chứa "a", "b" hoặc "c"
        System.out.println("\n2. [^abc] → Không chứa 'a', 'b' hoặc 'c'");
        testRegex("[^abc]", "d");  // true
        testRegex("[^abc]", "a");  // false

        // 3. [a-z] → Bất kỳ chữ cái thường nào
        System.out.println("\n3. [a-z] → Chữ cái thường");
        testRegex("[a-z]", "m");  // true
        testRegex("[a-z]", "Z");  // false

        // 4. [A-Z] → Bất kỳ chữ cái in hoa nào
        System.out.println("\n4. [A-Z] → Chữ cái in hoa");
        testRegex("[A-Z]", "M");  // true
        testRegex("[A-Z]", "z");  // false

        // 5. [0-9] → Chỉ chứa chữ số
        System.out.println("\n5. [0-9] → Chữ số");
        testRegex("[0-9]", "5");  // true
        testRegex("[0-9]", "a");  // false

        // 6. [a-zA-Z0-9] → Chữ cái hoặc số
        System.out.println("\n6. [a-zA-Z0-9] → Chữ cái hoặc số");
        testRegex("[a-zA-Z0-9]", "A");  // true
        testRegex("[a-zA-Z0-9]", "9");  // true
        testRegex("[a-zA-Z0-9]", "!");  // false
    }

    public static void testRegex(String pattern, String text) {
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("Pattern: \"" + pattern + "\" | Text: \"" + text + "\" | Match: " + matches);
    }
}
