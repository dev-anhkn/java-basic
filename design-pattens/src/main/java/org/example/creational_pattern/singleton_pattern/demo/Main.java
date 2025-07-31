package org.example.creational_pattern.singleton_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Lần đầu lấy instance => tạo mới
        MySingleton obj1 = MySingleton.getInstance();
        obj1.showMessage("Hello from obj1");

        // Lần sau lấy instance => dùng lại instance cũ
        MySingleton obj2 = MySingleton.getInstance();
        obj2.showMessage("Hello from obj2");

        // So sánh 2 biến có cùng instance không
        if (obj1 == obj2) {
            logger.info("obj1 và obj2 là cùng một đối tượng Singleton!");
        } else {
            logger.info("2 đối tượng khác nhau (KHÔNG đúng với Singleton!)");
        }
    }
}
