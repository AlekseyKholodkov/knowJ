package _util._concurrent._semaphore._mutex;

import _util._concurrent._semaphore._mutex.Cart;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private Semaphore semaphore;
    private String workerName;
    private boolean adder;

    public Worker(Semaphore semaphore, String workerName, boolean adder) {
        this.semaphore = semaphore;
        this.workerName = workerName;
        this.adder = adder;
    }

    @Override
    public void run() {
        System.out.println(workerName + " started working...");
        try {
            System.out.println(workerName + " waiting for cart...");
            semaphore.acquire();
            System.out.println(workerName + " got access to cart...");
            for (int i = 0; i < 10; i++) {
                if (adder) {
                    Cart.addWeight();
                } else {
                    Cart.reduceWeight();
                }
                System.out.println(workerName + " changed weight to " + Cart.getWeight());
                Thread.sleep(10L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        } finally {
            System.out.println(workerName + " finishing working with cart.");
            semaphore.release(1);
        }
    }
}
