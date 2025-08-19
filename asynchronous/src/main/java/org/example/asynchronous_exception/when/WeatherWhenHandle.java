package org.example.asynchronous_exception.when;

import java.util.function.BiConsumer;

public class WeatherWhenHandle implements BiConsumer<String, Throwable> {

    @Override
    public void accept(String result, Throwable error) {
        if (error != null) {
            System.out.println("WhenHandle: Lỗi xảy ra: " + error.getMessage());
        } else {
            System.out.println("WhenHandle: Dữ liệu thời tiết: " + result);
        }
    }
}
