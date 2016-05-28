package _util._concurrent;

import java.util.concurrent.TimeUnit;

public class WaitNotifyExample {
    static final Object sync = new Object();

    public static void main(String[] args) {
        Thread thread_0 = new Thread(new WaitingThread(sync));
        Thread thread_1 = new Thread(new WaitingThread(sync));
        thread_0.setPriority(Thread.MIN_PRIORITY);
        thread_1.setPriority(Thread.MAX_PRIORITY);
        thread_0.start();
        thread_1.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ":: Interrupted: " + e);
            }
        synchronized (sync) {
            System.out.println(Thread.currentThread().getName() + ":: Acquire monitor. Thread priority: " + Thread.currentThread().getPriority());
            System.out.println(Thread.currentThread().getName() + ":: Calling notifyAll()");
            sync.notifyAll();
            System.out.println(Thread.currentThread().getName() + ":: Sleeping for 1 seconds");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ":: Interrupted: " + e);
            }
            System.out.println(Thread.currentThread().getName() + ":: Exiting synchronized block");
        }
    }

    static class WaitingThread implements Runnable {
        private final Object sync;

        public WaitingThread(Object sync) {
            this.sync = sync;
        }

        @Override
        public void run() {
            synchronized (sync) {
                System.out.println(Thread.currentThread().getName() + ":: Acquire monitor. Thread priority: " + Thread.currentThread().getPriority());
                System.out.println(Thread.currentThread().getName() + ":: Waiting");
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ":: Interrupted: " + e);
                }
                System.out.println(Thread.currentThread().getName() + ":: Wake up.");
                System.out.println(Thread.currentThread().getName() + ":: Calling notifyAll()");
                sync.notifyAll();
                System.out.println(Thread.currentThread().getName() + ":: Sleeping for 1 seconds");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ":: Interrupted: " + e);
                }
                System.out.println(Thread.currentThread().getName() + ":: Exiting synchronized block");
            }
        }
    }
}
