package org.example.testing;

import java.util.regex.*;

public class QuantifierExample {
    public static void main(String[] args) {
        // 1. * (0 hoặc nhiều lần)
        System.out.println("1. * (0 hoặc nhiều lần)");
        testRegex("a*", "");     // true (0 lần)
        testRegex("a*", "a");    // true (1 lần)
        testRegex("a*", "aaa");  // true (nhiều lần)
        testRegex("a*", "b");    // false (vì có thể khớp với "")

        // 2. + (ít nhất 1 lần)
        System.out.println("\n2. + (ít nhất 1 lần)");
        testRegex("a+", "");     // false (0 lần)
        testRegex("a+", "a");    // true (1 lần)
        testRegex("a+", "aaa");  // true (nhiều lần)
        testRegex("a+", "b");    // false

        // 3. ? (0 hoặc 1 lần)
        System.out.println("\n3. ? (0 hoặc 1 lần)");
        testRegex("a?", "");     // true (0 lần)
        testRegex("a?", "a");    // true (1 lần)
        testRegex("a?", "aa");   // false (2 lần)
        testRegex("a?", "b");    // true (vì có thể khớp với "")

        // 4. {n} (chính xác n lần)
        System.out.println("\n4. {n} (chính xác n lần)");
        testRegex("a{3}", "aaa"); // true (3 lần)
        testRegex("a{3}", "aa");  // false (2 lần)
        testRegex("a{3}", "aaaa"); // false (4 lần)

        // 5. {n,} (ít nhất n lần)
        System.out.println("\n5. {n,} (ít nhất n lần)");
        testRegex("a{2,}", "aa");   // true (2 lần)
        testRegex("a{2,}", "aaaa"); // true (4 lần)
        testRegex("a{2,}", "a");    // false (1 lần)

        // 6. {n,m} (từ n đến m lần)
        System.out.println("\n6. {n,m} (từ n đến m lần)");
        testRegex("a{2,4}", "aa");    // true (2 lần)
        testRegex("a{2,4}", "aaa");   // true (3 lần)
        testRegex("a{2,4}", "aaaa");  // true (4 lần)
        testRegex("a{2,4}", "a");     // false (1 lần)
        testRegex("a{2,4}", "aaaaa"); // false (5 lần)
    }

    public static void testRegex(String pattern, String text) {
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("Pattern: \"" + pattern + "\" | Text: \"" + text + "\" | Match: " + matches);
    }
}
