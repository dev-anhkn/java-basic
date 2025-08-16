package org.example.testing;

import java.util.regex.*;

public class AnchorsExample {
    public static void main(String[] args) {
        // 1. ^ (Bắt đầu chuỗi)
        System.out.println("1. Bắt đầu chuỗi (^Hello)");
        testRegex("^Hello", "Hello world");  // true
        testRegex("^Hello", "world Hello");  // false

        // 2. $ (Kết thúc chuỗi)
        System.out.println("\n2. Kết thúc chuỗi (world$)");
        testRegex("world$", "Hello world");  // true
        testRegex("world$", "world Hello");  // false

        // 3. \b (Ranh giới từ)
        System.out.println("\n3. Ranh giới từ (\\bJava\\b)");
        testRegex("\\bJava\\b", "I love Java!");  // true
        testRegex("\\bJava\\b", "JavaScript is cool");  // false

        // 4. \B (Không phải ranh giới từ)
        System.out.println("\n4. Không phải ranh giới từ (\\BJava\\B)");
        testRegex("\\BJava\\B", "aaJavaaa");  // true
        testRegex("\\BJava\\B", "Java is fun");  // false
    }

    public static void testRegex(String pattern, String text) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        boolean matches = m.find();
        System.out.println("Pattern: \"" + pattern + "\" | Text: \"" + text + "\" | Match: " + matches);
    }
}
