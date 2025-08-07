package org.example.classes;

public class GenericClassExample {

    public static void main(String[] args) {
        GenericClass<Integer> intBox = new GenericClass<>();
        intBox.setValue(10);
        //intBox.setValue("Hello"); // Type Safety: không thể truyền sai kiểu dữ liệu
        Integer value = intBox.getValue(); // Explicit Casting : Không cần ép kiểu dữ liệu
        System.out.println(value);

        GenericClass<String> strBox = new GenericClass<>();
        strBox.setValue("Hello");
        String string = strBox.getValue();
        System.out.println(string);

        //GenericClass<int> box = new GenericClass<>();// Không thể khởi tạo generic cho kiểu nguyên thủy
        //GenericClass<Integer>[] boxs = new GenericClass<>[10];// Không thể khởi tạo mảng kiểu generic

    }

}
