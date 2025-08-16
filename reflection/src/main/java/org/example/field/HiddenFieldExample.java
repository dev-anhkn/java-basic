package org.example.field;

import java.lang.reflect.Field;

public class HiddenFieldExample {

    public static void main(String[] args) throws Exception {

        HiddenField example = new HiddenField();

        // Truy cập vào trường private
        Field field = HiddenField.class.getDeclaredField("secretMessage");
        field.setAccessible(true); // Cho phép truy cập trường private
        String value = (String) field.get(example); // Lấy giá trị của trường
        System.out.println("Giá trị của secretMessage: " + value);
    }
}