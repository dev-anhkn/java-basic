package org.example.synchronization.solution.synchronization;

public class TicketTaskSynchronized implements Runnable {
    private TicketBookingSynchronized system;

    public TicketTaskSynchronized(TicketBookingSynchronized system) {
        this.system = system;
    }

    @Override
    public void run() {

        system.bookSeat(Thread.currentThread().getName());
    }
}
