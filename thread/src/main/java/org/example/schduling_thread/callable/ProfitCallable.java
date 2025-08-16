package org.example.schduling_thread.callable;

import java.util.concurrent.Callable;

public class ProfitCallable implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        System.out.println("Đang tính toán lợi nhuận dự kiến...");
        // Giả lập thời gian tính toán (3 giây)
        Thread.sleep(3000);
        return Math.random() * 10000;  // Trả về lợi nhuận dự kiến ngẫu nhiên
    }
}
