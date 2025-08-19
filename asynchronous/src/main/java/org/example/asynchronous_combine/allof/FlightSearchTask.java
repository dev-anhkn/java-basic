package org.example.asynchronous_combine.allof;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class FlightSearchTask implements Supplier<List<String>> {
    private final String airline;

    public FlightSearchTask(String airline) {
        this.airline = airline;
    }

    @Override
    public List<String> get() {
        try {
            Random random = new Random();
            int delay = random.nextInt(5) + 1; // Random từ 2s đến 6s
            TimeUnit.SECONDS.sleep(delay); // Giả lập thời gian phản hồi từ API
            System.out.println("Đã gọi API " + airline + " trong thời gian " + delay + " giây");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        List<String> result = new ArrayList<>();
        result.add(airline + " - Flight 101" );
        result.add(airline + " - Flight 202");
        return result;
    }
}
