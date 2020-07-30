package ygf.benchmark.json.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JMH_Samle {

    @Benchmark
    public void test(){

    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(JMH_Samle.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
