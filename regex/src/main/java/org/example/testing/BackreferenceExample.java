package org.example.testing;

import java.util.regex.*;
  
public class BackreferenceExample {
    public static void main(String[] args) {
        // 1. Kiểm tra chuỗi có hai từ giống nhau liên tiếp (ví dụ: "hello hello")
        System.out.println("1. Tìm hai từ trùng lặp liên tiếp");
        testRegex("(\\b\\w+\\b) \\1", "hello hello");  // true
        testRegex("(\\b\\w+\\b) \\1", "hello world");  // false

        // 2. Kiểm tra chữ cái lặp lại liên tiếp (ví dụ: "aa", "bb")
        System.out.println("\n2. Tìm chữ cái lặp lại liên tiếp");
        testRegex("(.)\\1", "aa");  // true
        testRegex("(.)\\1", "ab");  // false

        // 3. Tìm các cặp số lặp lại (ví dụ: "12 12", "99 99")
        System.out.println("\n3. Tìm số trùng lặp");
        testRegex("(\\d+) \\1", "12 12");  // true
        testRegex("(\\d+) \\1", "34 56");  // false

        // 4. Tìm dấu ngoặc đơn có đóng/mở trùng nhau (ví dụ: "(abc)abc")
        System.out.println("\n4. Tìm dấu ngoặc đóng mở trùng nhau");
        testRegex("\\((.*?)\\)\\1", "(abc)abc");  // true
        testRegex("\\((.*?)\\)\\1", "(abc)def");  // false
    }

    public static void testRegex(String pattern, String text) {
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("Pattern: \"" + pattern + "\" | Text: \"" + text + "\" | Match: " + matches);
    }
}
