package _concurrency;

public class MultiThreading extends Thread {
    private int x = 2;

    public static void main(String[] args) throws Exception {
        new MultiThreading().makeItSo();
    }

    public MultiThreading() {
        x = 5;
        start();
    }

    public void makeItSo() throws Exception {
        join();
        x = x - 1;
        System.out.println(x);
    }

    public void run() { x *= 2; }

    public void start() {
        super.start();
    }
}
