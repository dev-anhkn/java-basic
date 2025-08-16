package org.example.thread_pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class ShutdownExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit một vài tác vụ ví dụ
        executor.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task 1 hoàn thành bởi " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.err.println("Task 1 bị gián đoạn");
                }
            }
        });

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task 2 hoàn thành bởi " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.err.println("Task 2 bị gián đoạn");
            }
        });

        // Từ chối nhận thêm task mới
        executor.shutdown();

        try {
            // Chờ đợi tối đa 3 giây cho các task hoàn thành
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Không đủ thời gian chờ, gọi shutdownNow()");
                List<Runnable> notExecuted = executor.shutdownNow();
                System.out.println("Số task chưa thực thi: " + notExecuted.size());
            } else {
                System.out.println("Tất cả các task đã hoàn thành.");
            }
        } catch (InterruptedException e) {
            System.err.println("Chờ đợi bị gián đoạn, gọi shutdownNow()");
            List<Runnable> notExecuted = executor.shutdownNow();
            System.out.println("Số task chưa thực thi: " + notExecuted.size());
        }
    }
}
