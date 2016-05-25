package _util._concurrent._semaphore;

public class Cart {
    private static int weight = 0;

    public static void addWeight() {
        weight++;
    }

    public static void reduceWeight() {
        weight--;
    }

    public static int getWeight() {
        return weight;
    }

    public static boolean isEmpty() {
        return weight == 0;
    }
}
