package org.example.testing;

import java.util.regex.*;

public class SpecialCharacterRegexExample {
    public static void main(String[] args) {
        String text = "Website: www.example.com";
        // Cách 1: Tự thêm kí tự escape
        // Dấu chấm là ký tự đặc biệt trong Regex, cần thoát bằng `\.`
        // Nhưng vì '\' lại là 1 kí tự đặc biệt trong chuỗi để escape kí tự đặc biệt(\n, \t...)
        // nên chúng ta phải thêm 2 lần '\\'.
        //String regex = "\\.";

        // Cách 2: sử dụng hàm escape
        // Chỉ sử dụng khi so khớp chính xác với chuỗi mong muốn.
        // Không sử dụng với các kí tự đại diện trong Regex
        //String regex = Pattern.quote(".");

        // Cách 3: thêm option Literal để xử lý như kí tự bình thường
        String regex = ".";
        Pattern pattern = Pattern.compile(regex, Pattern.LITERAL);

        //Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Dấu chấm tìm thấy tại vị trí: " + matcher.start());
        }

        System.out.println("Tổng số dấu chấm trong chuỗi: " + count);
    }
}
