package org.example.synchronization.solution.reentrantlock;

public class TicketTaskReentrantLock implements Runnable {
    private TicketBookingReentrantLock system;

    public TicketTaskReentrantLock(TicketBookingReentrantLock system) {
        this.system = system;
    }

    @Override
    public void run() {

        system.bookSeat(Thread.currentThread().getName());
    }
}
