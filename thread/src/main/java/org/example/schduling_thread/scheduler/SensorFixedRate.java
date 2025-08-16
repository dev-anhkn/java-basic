package org.example.schduling_thread.scheduler;


import org.example.schduling_thread.task.SensorTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SensorFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Bắt đầu ghi nhận dữ liệu cảm biến...");

        scheduler.scheduleAtFixedRate(new SensorTask(), 0, 10, TimeUnit.SECONDS);

        // Giữ chương trình chạy trong 1 phút để quan sát
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }
}
