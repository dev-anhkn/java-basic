package org.example.asynchronous_exception.consumer;


import com.example.supplier.WeatherSupplier;

import java.util.concurrent.CompletableFuture;

public class WeatherConsumerMain {
    public static void main(String[] args) {
        System.out.println("[Main] Đang lấy thông tin thời tiết...");

        // Gọi API lấy thời tiết bất đồng bộ bằng Supplier
        CompletableFuture<String> weatherFuture = CompletableFuture.supplyAsync(new WeatherSupplier());

        // Lấy kết quả - Không chặn luồng chính
        weatherFuture.thenAccept(new WeatherConsumer());

        System.out.println("[Main] Tiếp tục làm việc trong khi chờ dữ liệu...");

        // Giữ chương trình chạy lâu hơn để thấy kết quả (chỉ dùng để quan sát)
        try {
           Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
