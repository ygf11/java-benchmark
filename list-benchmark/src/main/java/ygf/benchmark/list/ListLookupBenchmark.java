package ygf.benchmark.list;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * list point loop bench
 *
 * @author yanggaofeng
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ListLookupBenchmark {

    @Param({"100000"})
    private int count;

    private List<Integer> arrayList;

    private List<Integer> linkedList;

    @Setup
    public void setup(){
        arrayList = new ArrayList<>(count);
        for (int i = 0; i < count; ++i){
            arrayList.add(i,i);
        }

        linkedList = new LinkedList<>();
        for (int i = 0; i < count; ++i){
            linkedList.add(i,i);
        }

    }

    @Benchmark
    public void arrayListLookup(){
        for (int i = 0; i < count; ++i){
            int value = arrayList.get(i);

            value++;
        }
    }

    @Benchmark
    public void linkedListLookup(){
        for (int i = 0; i < count; ++i){
            int value = linkedList.get(i);

            value++;
        }
    }

    public static void main(String[] args) throws Exception{
        Options options = new OptionsBuilder()
                .include(ListLookupBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();
    }

}
