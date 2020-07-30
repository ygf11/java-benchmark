package ygf.benchmark.list;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * list insert benchmark
 *
 * @author yanggaofeng
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ListInsertBenchmark {

    @Param({"100000"})
    private int count;


    @Benchmark
    public void arrayListHeadInsertTest() {
        List<Integer> list = new ArrayList<>(count);

        for (int i = 0; i < count; ++i) {
            list.add(0, i);
        }
    }

    @Benchmark
    public void linkedListHeadInsertTest() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < count; ++i) {
            list.add(0, i);
        }
    }

    @Benchmark
    public void arrayListMiddleInsertTest() {
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            int pos = i / 2;
            list.add(pos, i);
        }
    }

    @Benchmark
    public void linkedListMiddleInsertTest() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; ++i) {
            int pos = i / 2;
            list.add(pos, i);
        }
    }

    @Benchmark
    public void arrayListTailInsertTest(){
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            list.add(i);
        }
    }

    @Benchmark
    public void linkedListTailInsertTest(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < count; ++i){
            list.add(i);
        }
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(ListInsertBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();

    }
}
