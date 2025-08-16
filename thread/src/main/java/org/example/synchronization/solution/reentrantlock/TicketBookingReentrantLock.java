package org.example.synchronization.solution.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingReentrantLock {
    private int availableSeats = 10; // Số ghế trống
    private List<String> bookedSeats = new ArrayList<>(); // Danh sách ghế đã đặt
    private final ReentrantLock lock = new ReentrantLock(); // Tạo lock để kiểm soát truy cập

    public void bookSeat(String customer) {
        lock.lock(); // Khóa trước khi kiểm tra và cập nhật
        try {
            if (availableSeats > 0) {
                System.out.println(customer + " đang đặt vé...");
                try {
                    Thread.sleep(100); // Giả lập độ trễ khi xử lý
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                availableSeats--; // Giảm số ghế trống
                bookedSeats.add(customer);
                System.out.println(customer + " đã đặt vé thành công! Số ghế còn lại: " + availableSeats);
            } else {
                System.out.println(customer + " không thể đặt vé, đã hết chỗ!");
            }
        } finally {
            lock.unlock(); // Luôn mở khóa, dù có lỗi hay không
        }
    }

}
