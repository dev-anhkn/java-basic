package org.example.asynchronous_combine.compose;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class DiscountTaskCompose implements Function<Double, CompletableFuture<Double>> {
    @Override
    public CompletableFuture<Double> apply(Double price) {
        return CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                try {
                    Random random = new Random();
                    int delay = random.nextInt(5) + 1; // Random từ 2s đến 6s
                    TimeUnit.SECONDS.sleep(delay); // Giả lập thời gian phản hồi từ API
                    System.out.println("Đã gọi API lấy giảm giá trong thời gian " + delay + " giây");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return price - 50.0; // Giảm giá 50 đơn vị tiền tệ
            }
        });
    }
}
