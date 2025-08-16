package org.example.schduling_thread.task;

public class EmailTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Gửi email xác nhận tài khoản...");
    }
}
