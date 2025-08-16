package org.example.application;

public class RegexSplit {
    public static void main(String[] args) {
        String text = "apple,orange;banana grape";
        String pattern = "[,; ]+"; // Dấu phân cách là dấu phẩy, dấu chấm phẩy, hoặc khoảng trắng

        String[] result = text.split(pattern);
        for (String word : result) {
            System.out.println(word);
        }
    }
}
