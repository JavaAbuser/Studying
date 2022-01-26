package MultiThreading_1;

import java.util.List;

public class Casa extends Thread {
    private int id;
    private List<Ticket> tickets;
    int[] ticketQueue = new int[Cinema.getTicketsCount()];

    public Casa(int id, List<Ticket> tickets) {
        this.id = id;
        this.tickets = tickets;
    }

    @Override
    public synchronized void run() {
        System.out.println("Current thread`s name is " + Thread.currentThread().getName());
    }

    public synchronized Ticket buy(int filmId) throws InterruptedException {
        Ticket ticket = null;
        if (!tickets.isEmpty()) {
            System.out.println(this.getName() + " is working...");
            for (Ticket tick : tickets) {
                if (tick.getId() == filmId) {
                    ticket = tickets.get(tickets.indexOf(tick));
                }
            }
            tickets.remove(ticket);
            System.out.println("Ticket with id " + filmId + " was bought by " + this.getName());
        }
        return ticket;
    }
}
