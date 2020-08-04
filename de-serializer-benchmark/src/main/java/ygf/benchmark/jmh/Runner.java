package ygf.benchmark.jmh;


import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * de-serializer jmh benchmark
 *
 * @author yanggaofeng
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Runner {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(Runner.class.getSimpleName())
                .forks(1)
                .build();
        new org.openjdk.jmh.runner.Runner(options).run();
    }
}
