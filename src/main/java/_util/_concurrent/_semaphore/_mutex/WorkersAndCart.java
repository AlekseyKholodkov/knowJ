package _util._concurrent._semaphore._mutex;

import java.util.concurrent.Semaphore;

/**
 * Два работника и тележка
 * Один работник наполняет тележку, второй перевозит ее и разгружает.
 * Пока один работник, наполняет тележку песком, второй работник ждет, чтоб отвезти ее.
 * Пока второй работник увез тележку, первый работник ждет пока ему привезут тележку обратно.
 */
public class WorkersAndCart {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Worker(semaphore, "Adder", true).start();
        new Worker(semaphore, "Reducer", false).start();
    }
}
