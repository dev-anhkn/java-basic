package org.example.synchronization.problem;

public class TicketTask implements Runnable {
    private final TicketBooking system;

    public TicketTask(TicketBooking system) {
        this.system = system;
    }

    @Override
    public void run() {

        system.bookSeat(Thread.currentThread().getName());
    }
}
