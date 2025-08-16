package org.example.schduling_thread.callable;

import java.util.concurrent.*;

public class FinancialPrediction {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Đợi 10 giây trước khi tính toán...");

        ScheduledFuture<Double> futureProfit = scheduler.schedule(new ProfitCallable(), 10, TimeUnit.SECONDS);

        try {
            // Chờ kết quả (blocking main thread)
            Double profit = futureProfit.get();
            System.out.println("Lợi nhuận dự kiến: $" + profit);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();

    }
}
