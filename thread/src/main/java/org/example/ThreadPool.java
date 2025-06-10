package org.example;


import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {

    // Mỗi thread sẽ có 1 biến totalMoneyInWallet riêng biệt
    private static final ThreadLocal<Integer> totalMoneyInWallet = ThreadLocal.withInitial(() -> {
        return 0; // Giá trị ví ban đầu cho mỗi thread
    });

    // Biến tổng số tiền nhận vào từ tất cả các thread (phải thread-safe)
    private static final AtomicInteger totalAllMoney = new AtomicInteger(0);

    // Không cần synchronized vì mỗi thread có 1 bản riêng
    private static void getMoney(int money) {
        System.out.println(Thread.currentThread().getName() + " : Customer gives " + money);

        // Lấy số tiền hiện tại trong ví (của thread hiện tại)
        int currentMoney = totalMoneyInWallet.get();

        // Cập nhật số tiền trong ví (chỉ cho thread hiện tại)
        totalMoneyInWallet.set(currentMoney + money);

        // Cộng dồn vào tổng toàn hệ thống
        totalAllMoney.addAndGet(money);

        System.out.println(Thread.currentThread().getName() +
                " : Total money in wallet: " + totalMoneyInWallet.get() +
                " | TIME: " + LocalTime.now());

    }

    public static void main(String[] args) {
        // Tạo ThreadPool 10 thread cố định
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            threadPool.submit(() -> {
                // customer 1
                getMoney(new Random().nextInt(100));
                try {
                    Thread.sleep(2 * 10); // giả lập xử lý lâu
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // customer 2
                getMoney(new Random().nextInt(100));
            });
        }
        threadPool.shutdown();

        // Đợi cho threadPool kết thúc rồi in tổng tiền
        while (!threadPool.isTerminated()) {
            try {
                Thread.sleep(100); // Đợi 0.1 giây rồi kiểm tra lại
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("==== TỔNG SỐ TIỀN NHẬN VÀO: " + totalAllMoney.get() + " ====");


    }
}