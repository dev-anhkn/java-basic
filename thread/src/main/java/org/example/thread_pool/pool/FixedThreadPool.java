package org.example.thread_pool.pool;


import org.example.thread_pool.tasks.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread Pool có kích thước là 2, vì vậy chỉ có thể thực thi tối đa 2 tác vụ đồng thời.
 * Khi tác vụ 1 và 2 bắt đầu chạy trên các luồng riêng biệt, tác vụ 3 phải chờ đợi cho đến khi một trong hai luồng này trống trở lại trước khi nó được bắt đầu.
 * Sau khi tác vụ 1 và 2 hoàn thành, tác vụ 3 mới được thực thi.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // Tạo một Thread Pool có kích thước là 2
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // execute 3 tác vụ vào Thread Pool
        for (int i = 1; i <= 5; i++) {
            executor.execute(new MyTask("Thread-"+ i));
        }
        // Shutdown Thread Pool sau khi tất cả các tác vụ được hoàn thành
        executor.shutdown();


    }
}
