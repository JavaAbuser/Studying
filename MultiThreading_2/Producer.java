package MultiThreading_2;

public class Producer implements Runnable{
    Factory factory;

    public Producer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            factory.put();
        }
    }
}
