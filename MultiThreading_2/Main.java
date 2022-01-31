package MultiThreading_2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        Producer producer = new Producer(factory);
        Consumer consumer = new Consumer(factory);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(1000);

        System.out.println(factory.getOffers());
    }
}
