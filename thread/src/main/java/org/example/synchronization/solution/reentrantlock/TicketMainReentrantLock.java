package org.example.synchronization.solution.reentrantlock;

public class TicketMainReentrantLock {
    public static void main(String[] args) {

        // Dùng chung một đối tượng
        TicketBookingReentrantLock system = new TicketBookingReentrantLock();

        // Tạo 15 thread để đặt vé (nhiều hơn số ghế)
        Thread[] threads = new Thread[15];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new TicketTaskReentrantLock(system), "Khách " + (i + 1));
            threads[i].start();
        }

        // Chờ tất cả thread kết thúc
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
