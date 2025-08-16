package org.example.application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace2 {
    public static void main(String[] args) {
        // Chuỗi đầu vào
        String text = "Ngày sinh: 25-12-2023, Ngày khác: 01-01-2024";

        // Biểu thức chính quy với 3 nhóm bắt
        String regex = "(\\d{2})-(\\d{2})-(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Thay thế bằng cách sử dụng các nhóm
        String result = matcher.replaceAll("$3-$2-$1");

        // In kết quả
        System.out.println("Chuỗi gốc: " + text);
        System.out.println("Chuỗi sau thay thế: " + result);
    }
}
