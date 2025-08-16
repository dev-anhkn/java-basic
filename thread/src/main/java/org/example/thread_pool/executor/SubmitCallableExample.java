package org.example.thread_pool.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class SubmitCallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            public Integer call() {
                System.out.println("Task được thực hiện qua submit(Callable) bởi " + Thread.currentThread().getName());
                return 42;
            }
        });

        try {
            Integer result = future.get();
            System.out.println("Kết quả trả về từ Callable: " + result);
        } catch (InterruptedException e) {
            System.err.println("Task bị gián đoạn");
        } catch (ExecutionException e) {
            System.err.println("Lỗi trong task: " + e.getMessage());
        }

        executor.shutdown();
    }
}
