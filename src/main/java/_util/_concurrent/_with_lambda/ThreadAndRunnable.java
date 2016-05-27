package _util._concurrent._with_lambda;

public class ThreadAndRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hallo " + threadName);
        };
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Done!");
    }
}
