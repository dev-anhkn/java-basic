package org.example.schduling_thread.scheduler;


import org.example.schduling_thread.task.ApiTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ApiFetcherFixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Bắt đầu tải dữ liệu API...");

        scheduler.scheduleWithFixedDelay(new ApiTask(), 0, 10, TimeUnit.SECONDS);

        // Chạy trong 1 phút để quan sát
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown();
    }
}
