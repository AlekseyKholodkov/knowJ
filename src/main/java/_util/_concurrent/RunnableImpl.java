package _util._concurrent;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("RunnableImpl thread");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new RunnableImpl()).start();
        Thread.sleep(4000); // 4 sec
        System.out.println("Main thread");
    }
}
