package org.example.field;

import java.lang.reflect.Field;

public class FieldModifierExample {

    public static void main(String[] args) throws Exception {

        ModifierField example = new ModifierField();
        // Không thể truy cập field private trực tiếp
        // example.age = 30;

        // Thay đổi giá trị của trường private
        Field field = ModifierField.class.getDeclaredField("age");
        field.setAccessible(true); // Cho phép truy cập trường private
        System.out.println("Tuổi trước khi thay đổi: " + field.get(example));
        
        // Gán giá trị mới
        field.set(example, 30);
        System.out.println("Tuổi sau khi thay đổi: " + field.get(example));
    }
}