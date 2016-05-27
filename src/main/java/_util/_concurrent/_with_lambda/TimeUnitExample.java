package _util._concurrent._with_lambda;

import java.util.concurrent.TimeUnit;

public class TimeUnitExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("Foo " + threadName);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        runnable.run();

    }
}
