package org.example.classes;

public class ClassObjectExample {
    public static void main(String[] args) {
        // Lấy đối tượng Class bằng cách sử dụng .class
        Class<String> stringClass = String.class;
        System.out.println("Tên lớp: " + stringClass.getName() + ", package: " + stringClass.getPackage().getName());

        // Lấy đối tượng Class bằng cách sử dụng Class.forName
        try {
            Class<?> integerClass = Class.forName("java.lang.Integer");
            System.out.println("Tên lớp: " + integerClass.getName() + ", package: " + integerClass.getPackage().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}