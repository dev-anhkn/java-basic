package org.example.asynchronous_combine.combine;

import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ProductCombineMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("[Main] Bắt đầu gọi các API");

        CompletableFuture<Double> priceFuture = CompletableFuture.supplyAsync(new PriceTask());
        CompletableFuture<Double> discountFuture = CompletableFuture.supplyAsync(new DiscountTask());

        // Kết hợp giá gốc và giảm giá để tính giá cuối cùng
        CompletableFuture<Double> finalPriceFuture = priceFuture.thenCombine(discountFuture, new BiFunction<Double, Double, Double>() {
            @Override
            public Double apply(Double price, Double discount) {
                return price - discount;
            }
        });

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
