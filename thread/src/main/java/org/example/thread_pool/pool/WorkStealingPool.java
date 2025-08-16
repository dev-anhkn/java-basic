package org.example.thread_pool.pool;

import org.example.thread_pool.tasks.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPool {
    public static void main(String[] args) throws InterruptedException {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Số lượng Core CPU:" + core);

        // Tạo một Thread Pool phụ thuộc vào số core CPU(giả sử là 2 core)
        ExecutorService executor = Executors.newWorkStealingPool();

        // Submit 4 tác vụ vào Thread Pool
        for (int i = 1; i <= 15; i++) {
            executor.execute(new MyTask("Thread-"+i));
        }
        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS); // Đợi tối đa 3 giây
    }
}
