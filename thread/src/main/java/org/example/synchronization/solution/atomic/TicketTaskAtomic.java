package org.example.synchronization.solution.atomic;

public class TicketTaskAtomic implements Runnable {
    private TicketBookingAtomic system;

    public TicketTaskAtomic(TicketBookingAtomic system) {
        this.system = system;
    }

    @Override
    public void run() {
        system.bookSeat(Thread.currentThread().getName());
    }
}
