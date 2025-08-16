package org.example.schduling_thread.scheduler;


import org.example.schduling_thread.task.EmailTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OneTimeEmailSender {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Đã nhận yêu cầu đăng ký, sẽ gửi email sau 5 giây...");

        scheduler.schedule(new EmailTask(), 10 , TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
