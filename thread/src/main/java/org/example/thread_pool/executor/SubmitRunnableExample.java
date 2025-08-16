package org.example.thread_pool.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<?> future = executor.submit(new Runnable() {
            public void run() {
                System.out.println("Task được thực hiện qua submit(Runnable) bởi " + Thread.currentThread().getName());
            }
        });

        // Kiểm tra ngay lập tức
        System.out.println("Ngay sau submit, isDone: " + future.isDone());

        // Chờ task hoàn thành
        future.get();  // Đợi task hoàn thành

        // Kiểm tra lại sau khi get()
        System.out.println("Sau khi get(), isDone: " + future.isDone());

        executor.shutdown();
    }
}
