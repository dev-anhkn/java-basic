package org.example.asynchronous_combine.anyof;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class SearchProductMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("[Main] Bắt đầu gọi các API");

        CompletableFuture<String> providerA = CompletableFuture.supplyAsync(new SearchProductTask("Amazon"));
        CompletableFuture<String> providerB = CompletableFuture.supplyAsync(new SearchProductTask("Ebay"));
        CompletableFuture<String> providerC = CompletableFuture.supplyAsync(new SearchProductTask("Shopee"));

        // Lấy kết quả từ nhà cung cấp phản hồi nhanh nhất
        CompletableFuture<Object> fastestResponse = CompletableFuture.anyOf(providerA, providerB, providerC);

        fastestResponse.thenAccept(new Consumer<Object>() {
            @Override
            public void accept(Object result) {
                System.out.println("Nhận được kết quả nhanh nhất: " + result);
                System.out.println("Thời gian nhận kết quả sau " + (System.currentTimeMillis() - start)/1000 + " giây");
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