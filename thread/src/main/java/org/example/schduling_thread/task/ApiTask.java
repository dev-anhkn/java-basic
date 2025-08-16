package org.example.schduling_thread.task;

import java.util.Random;

public class  ApiTask implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        try {
            System.out.println("Đang gọi API... " + System.currentTimeMillis());

            // Giả lập thời gian phản hồi API (2-5 giây)
            int apiResponseTime = 2 + random.nextInt(4);
            Thread.sleep(apiResponseTime * 1000);

            System.out.println("Dữ liệu API nhận được sau " + apiResponseTime + " giây.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
