package org.example.testing;

import java.util.regex.*;

public class BasicRegexExample {
    public static void main(String[] args) {
        // Chuỗi cần kiểm tra
        String text = "I love Java programming!";
        
        // Regex cơ bản để tìm từ "Java"
        String regex = "Java";
        
        // Tạo Pattern và Matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        // Kiểm tra chuỗi có chứa "Java" không
        if (matcher.find()) {
            System.out.println("Chuỗi có chứa từ 'Java'!");
        } else {
            System.out.println("Chuỗi không chứa từ 'Java'.");
        }
    }
}
