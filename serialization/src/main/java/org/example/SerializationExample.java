package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) {
        // Tạo đối tượng Person
        Person person = new Person("Nga Neymar", 30, "mySecretPassword");

        // Đường dẫn tệp để lưu trữ đối tượng
        String filename = "serialization/src/main/resources/person.ser";

        // Serialization: Ghi đối tượng vào tệp
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Đã serialize đối tượng Person vào tệp " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}