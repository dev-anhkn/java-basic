package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {

        // Đường dẫn tệp để lưu trữ đối tượng
        String filename = "serialization/src/main/resources/person.ser";

        // Deserialization: Đọc đối tượng từ tệp
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Person person = (Person) in.readObject();
            System.out.println("Deserialize đối tượng Person từ tệp " + filename);
            System.out.println("Nội dung đối tượng Person: " + person);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}