package _util._concurrent;

public class SynchronizesMethod {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SynchronizesMethod counter = new SynchronizesMethod();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.increment();
            }
        });
    }
}
