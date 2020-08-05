package ygf.serialize.benchmark.jmh;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ygf.benchmark.protobuf.People;
import ygf.benchmark.protobuf.PersonUtil;

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

    @Param({"100000"})
    private int count;

    public static void printSerializeSize(){
        People.Person person = PersonUtil.build();
        System.out.println("proto buf size:" + person.toByteArray().length);
    }

    @Benchmark
    public void protoBufSerializerBench() {
        People.Person person = PersonUtil.build();
        for (int i = 0; i < count; ++i) {
            person.toByteArray();
        }
    }

    public static void main(String[] args) throws Exception {
        printSerializeSize();

        Options options = new OptionsBuilder()
                .include(Runner.class.getSimpleName())
                .forks(1)
                .build();
        new org.openjdk.jmh.runner.Runner(options).run();
    }
}
