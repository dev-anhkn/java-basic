package org.example.creational_pattern.builder_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Tạo xe tối giản
        Car car1 = new Car.Builder("Toyota", "Corolla").build();

        // Tạo xe với các option nâng cấp
        Car car2 = new Car.Builder("Honda", "Civic")
                .color("Red")
                .seats(2)
                .sunroof(true)
                .build();

        logger.info(car1.toString());
        logger.info(car2.toString());
    }
}
