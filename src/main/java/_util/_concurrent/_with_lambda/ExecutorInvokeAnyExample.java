package _util._concurrent._with_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeAnyExample {
    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callableList = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String invokeAny = executor.invokeAny(callableList);
        System.out.println(invokeAny);

    }
}
