package MultiThreading_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Steblevskiy(JavaAbuser) on 2.01.2022
 */
public class Cinema {
    public static List<Ticket> ticketList = null;
    public static void main(String[] args) throws InterruptedException {
        ticketList = new ArrayList<>(List.of(new Ticket(42, "Spider man"),
                new Ticket(3, "They among us"),
                new Ticket(85, "Throw the adventure"),
                new Ticket(41, "Around the world"),
                new Ticket(8, "Iceland survival")));

        Casa casa_1 = new Casa(1, ticketList);
        Casa casa_2 = new Casa(2, ticketList);
        Casa casa_3 = new Casa(3, ticketList);

        casa_1.start();
        casa_2.start();
        casa_3.start();

        Thread.sleep(2000);

        Ticket ticket1 = casa_1.buy(3);
        Ticket ticket2 = casa_2.buy(85);
        Ticket ticket3 = casa_3.buy(41);

        System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);
    }
    public static int getTicketsCount(){
        return ticketList.size();
    }
}
