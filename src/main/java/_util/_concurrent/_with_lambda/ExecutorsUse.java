package _util._concurrent._with_lambda;

import java.util.concurrent.*;

public class ExecutorsUse {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callableInt = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> futureInt = executor.submit(callableInt);
        System.out.println("future.isDone() == " + futureInt.isDone());
        Integer result = futureInt.get();
        System.out.println("future.get() == " + result);
        System.out.println("future.isDone() == " + futureInt.isDone());
    }
}
