package org.example.thread_pool.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

public class InvokeAllExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();
        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            tasks.add(new Callable<String>() {
                public String call() {
                    String result = "Kết quả của Task-" + taskId + " bởi " + Thread.currentThread().getName();
                    System.out.println(result);
                    // Giả lập xử lý
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // Xử lý nếu bị gián đoạn
                    }
                    return result;
                }
            });
        }

        try {
            List<Future<String>> futures = executor.invokeAll(tasks);
            for (Future<String> f : futures) {
                System.out.println("invokeAll trả về: " + f.get());
            }
        } catch (InterruptedException e) {
            System.err.println("invokeAll bị gián đoạn");
        } catch (ExecutionException e) {
            System.err.println("Lỗi trong task của invokeAll: " + e.getMessage());
        }

        executor.shutdown();
    }
}
