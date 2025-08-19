package org.example.asynchronous_exception.supplier;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class WeatherSupplier implements Supplier<String> {
    @Override
    public String get() {
        System.out.println("Supplier: đang xử lý...");
        try {
            TimeUnit.SECONDS.sleep(1); // Giả lập độ trễ khi gọi API
        } catch (InterruptedException e) {
            throw new RuntimeException("Supplier: Lỗi trong quá trình lấy dữ liệu!");
        }

        // Giả lập lỗi có thể xảy ra
        if (Math.random() < 0.5) {
            throw new RuntimeException("Supplier: Lỗi kết nối API thời tiết!");
        }

        return "Supplier: Thời tiết hôm nay: 28°C, có nắng nhẹ";
    }
}
