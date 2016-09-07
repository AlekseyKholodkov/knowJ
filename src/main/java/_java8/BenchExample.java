package _java8;

import org.openjdk.jmh.annotations.Benchmark;

public class BenchExample {
    @Benchmark
    public void firstBenchmark() {
        System.out.println("Benchmark");
    }
}
