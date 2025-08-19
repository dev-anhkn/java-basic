package org.example.asynchronous_combine.anyof;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SearchProductTask implements Supplier<String> {
    private final String providerName;

    public SearchProductTask(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String get() {
        try {
            Random random = new Random();
            int delay = random.nextInt(5) + 1; // Random từ 2s đến 6s
            TimeUnit.SECONDS.sleep(delay); // Giả lập thời gian phản hồi từ API
            System.out.println("Đã gọi API " + providerName + " trong thời gian " + delay + " giây");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Thông tin sản phẩm từ " + providerName;
    }

}