package MultiThreading_2;

public class Factory {
    private int productCount = 0;
    private volatile int offers = 0;

    public int getOffers(){
        return offers;
    }

    public synchronized void get(){
        while(productCount < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productCount--;
        offers++;
        System.out.println("Consumer got 1 product");
        System.out.println("Factory has " + productCount + " products now");
        notify();
    }
    public synchronized void put(){
        while(productCount >= 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productCount++;
        offers++;
        System.out.println("Producer put 1 product");
        System.out.println("Factory has " + productCount + " products now");
        notify();
    }
}
