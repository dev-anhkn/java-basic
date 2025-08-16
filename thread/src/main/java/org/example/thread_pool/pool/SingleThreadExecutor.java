package org.example.thread_pool.pool;

import org.example.thread_pool.tasks.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Chỉ có một thread duy nhất chạy tuần tự các tác vụ.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Thực thi 3 tác vụ vào Thread Pool
        for (int i = 1; i <= 3; i++) {
            executor.execute(new MyTask("Thread-" + i));
        }
        // Shutdown Thread Pool sau khi tất cả các tác vụ được hoàn thành
        executor.shutdown();

    }
}
