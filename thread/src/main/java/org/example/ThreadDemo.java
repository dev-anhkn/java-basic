package org.example;


import java.time.LocalTime;
import java.util.Random;

public class ThreadDemo {

    private static int totalMoneyInWallet = 0;

    private static synchronized void getMoney(int money) {
        System.out.println(java.lang.Thread.currentThread().getName() + " KHACH " + money);
        totalMoneyInWallet += money;
        System.out.println(java.lang.Thread.currentThread().getName() + " TOTAL " + totalMoneyInWallet + " TIME | " + LocalTime.now());
    }

    public   void main(String[] args) {

        System.out.println("CPU core available: " + Runtime.getRuntime().availableProcessors());

        for (int i = 0; i <=100; i++) {
            java.lang.Thread cashier1 = new java.lang.Thread(() -> {
                getMoney(new Random().nextInt(100));
                try {
                    java.lang.Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                getMoney(new Random().nextInt(100));


            }, "cashier" + i);
            cashier1.start();
        }

    }
}