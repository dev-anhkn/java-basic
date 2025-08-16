package org.example.synchronization.solution.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;

public class TicketBookingAtomic {
    private final AtomicInteger availableSeats = new AtomicInteger(10); // Dùng AtomicInteger để tránh race condition
    private final List<String> bookedSeats = new ArrayList<>();

    public void bookSeat(String customer) {
        System.out.println(customer + " đang đặt vé...");

        try {
            Thread.sleep(100); // Giả lập độ trễ
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (availableSeats.get() > 0) { // Kiểm tra trước
            int remainingSeats = availableSeats.getAndDecrement(); // Giảm số ghế nguyên tử

            if (remainingSeats > 0) { // Kiểm tra sau khi giảm
                bookedSeats.add(customer);
                System.out.println(customer + " đã đặt vé thành công! Số ghế còn lại: " + (remainingSeats - 1));
            } else { // Nếu lỡ giảm quá mức
                System.out.println(customer + " không thể đặt vé, đã hết chỗ!");
                availableSeats.incrementAndGet(); // Phục hồi số ghế nếu bị âm
            }
        } else {
            System.out.println(customer + " không thể đặt vé, đã hết chỗ!");
        }
    }


}
