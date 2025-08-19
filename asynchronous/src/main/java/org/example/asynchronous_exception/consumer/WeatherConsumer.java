package org.example.asynchronous_exception.consumer;

import java.util.function.Consumer;

public class WeatherConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println("Consumer: Dữ liệu nhận được: " + s);
    }
}
