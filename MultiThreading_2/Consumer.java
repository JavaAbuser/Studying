package MultiThreading_2;

public class Consumer implements Runnable{
    Factory factory;

    public Consumer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            factory.get();
        }
    }
}
