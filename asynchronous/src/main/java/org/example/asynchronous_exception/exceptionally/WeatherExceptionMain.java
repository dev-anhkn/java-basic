package org.example.asynchronous_exception.exceptionally;

import com.example.consumer.WeatherConsumer;
import com.example.supplier.WeatherSupplier;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WeatherExceptionMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("[Main] Đang lấy thông tin thời tiết...");

        // Gọi API lấy thời tiết bất đồng bộ bằng Supplier
        CompletableFuture<String> weatherFuture = CompletableFuture.supplyAsync(new WeatherSupplier());

        // Xử lý lỗi nếu xảy ra và trả về giá trị thay thế nếu có lỗi
        CompletableFuture<String> exceptionHandle = weatherFuture.exceptionally(new WeatherExceptionFunction());

        // Xủ lý kết quả cuối cùng
        exceptionHandle.thenAccept(new WeatherConsumer());

        System.out.println("[Main] Tiếp tục làm việc trong khi chờ dữ liệu...");

        // Giữ chương trình chạy lâu hơn để thấy kết quả (chỉ dùng để quan sát)
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
