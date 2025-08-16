package org.example.thread_pool.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

public class InvokeAnyExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            tasks.add(new Callable<String>() {
                public String call() {
                    String result = "Kết quả của Task-" + taskId + " bởi " + Thread.currentThread().getName();
                    // Giả lập thời gian xử lý khác nhau
                    try {
                        Thread.sleep(500 + taskId * 200);
                    } catch (InterruptedException e) {
                        // Xử lý nếu bị gián đoạn
                    }
                    System.out.println(result);
                    return result;
                }
            });
        }

        try {
            // invokeAny sẽ trả về kết quả của task nào hoàn thành đầu tiên
            String result = executor.invokeAny(tasks);
            System.out.println("invokeAny trả về: " + result);
        } catch (InterruptedException e) {
            System.err.println("invokeAny bị gián đoạn");
        } catch (ExecutionException e) {
            System.err.println("Lỗi trong task của invokeAny: " + e.getMessage());
        }

        executor.shutdown();
    }
}
