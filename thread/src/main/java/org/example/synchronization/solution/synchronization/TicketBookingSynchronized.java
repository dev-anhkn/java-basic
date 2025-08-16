package org.example.synchronization.solution.synchronization;

import java.util.ArrayList;
import java.util.List;

class TicketBookingSynchronized {
    private int availableSeats = 10; // Số ghế trống
    private List<String> bookedSeats = new ArrayList<>(); // Danh sách ghế đã đặt

    public synchronized void bookSeat(String customer) {
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
    }
}
