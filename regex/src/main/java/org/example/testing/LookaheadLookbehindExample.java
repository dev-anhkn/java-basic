package org.example.testing;

import java.util.regex.*;

public class LookaheadLookbehindExample {
    public static void main(String[] args) {
        // 1. Positive Lookahead: Java phải có số sau nó
        System.out.println("1. Positive Lookahead: Java(?=\\d)");
        testRegex("Java(?=\\d)", "Java123");  // true
        testRegex("Java(?=\\d)", "Java!");  // false

        // 2. Negative Lookahead: Java không có số sau nó
        System.out.println("\n2. Negative Lookahead: Java(?!\\d)");
        testRegex("Java(?!\\d)", "Java!");  // true
        testRegex("Java(?!\\d)", "Java123");  // false

        // 3. Positive Lookbehind: Java phải có số trước nó
        System.out.println("\n3. Positive Lookbehind: (?<=\\d)Java");
        testRegex("(?<=\\d)Java", "123Java");  // true
        testRegex("(?<=\\d)Java", "!Java");  // false

        // 4. Negative Lookbehind: Java không có số trước nó
        System.out.println("\n4. Negative Lookbehind: (?<!\\d)Java");
        testRegex("(?<!\\d)Java", "!Java");  // true
        testRegex("(?<!\\d)Java", "123Java");  // false
    }

    public static void testRegex(String pattern, String text) {
        boolean matches = Pattern.compile(pattern).matcher(text).find();
        System.out.println("Pattern: \"" + pattern + "\" | Text: \"" + text + "\" | Match: " + matches);
    }
}
