package org.example.schduling_thread.task;

import java.util.Random;

public class SensorTask implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        double temperature = 20 + (random.nextDouble() * 10); // Giả lập nhiệt độ từ 20 đến 30 độ C
        System.out.println("Cập nhật dữ liệu cảm biến: " + temperature + "°C - " + System.currentTimeMillis());
    }
}
