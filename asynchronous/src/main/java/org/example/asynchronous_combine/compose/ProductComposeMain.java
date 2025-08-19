package org.example.asynchronous_combine.compose;

import org.example.asynchronous_combine.combine.PriceTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ProductComposeMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("[Main] Bắt đầu gọi các API");

        CompletableFuture<Double> priceFuture = CompletableFuture.supplyAsync(new PriceTask());

        CompletableFuture<Double> finalPriceFuture = priceFuture.thenCompose(new DiscountTaskCompose());

        finalPriceFuture.thenAccept(new Consumer<Double>() {
            @Override
            public void accept(Double finalPrice) {
                System.out.println("Giá cuối cùng sau giảm giá: " + finalPrice);
                System.out.println("Thời gian kết hợp kết quả sau " + (System.currentTimeMillis() - start)/1000 + " giây");
            }
        });

        System.out.println("[Main] Main vẫn tiếp tục làm việc khác");
        try {
            TimeUnit.SECONDS.sleep(10); // Chờ để quan sát kết quả
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
