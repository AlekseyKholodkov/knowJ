package _util._concurrent;

public class ThreadExtend extends Thread { // or implements Runnable
    @Override
    public void run() {
        System.out.println("RunnableImpl thread");
    }

    public static void main(String[] args) {
        new Thread(new ThreadExtend()).start();
        System.out.println("Main thread");

    }
}
