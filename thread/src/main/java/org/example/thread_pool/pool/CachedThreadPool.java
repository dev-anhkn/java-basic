package org.example.thread_pool.pool;

import org.example.thread_pool.tasks.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Tạo thread mới khi cần, nhưng sẽ tái sử dụng các thread cũ nếu có. Không giới hạn số thread tối đa.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit 3 tác vụ vào Thread Pool
        for (int i = 1; i <= 20; i++) {
            executor.execute(new MyTask("Thread-" + i));
        }
        // Shutdown Thread Pool sau khi tất cả các tác vụ được hoàn thành
        executor.shutdown();


    }
}
