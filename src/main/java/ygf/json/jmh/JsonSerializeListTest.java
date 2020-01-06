package ygf.json.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ygf.json.beans.Person;
import ygf.json.utils.FastJsonUtils;
import ygf.json.utils.GsonUtils;
import ygf.json.utils.JacksonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonSerializeListTest {

    @Param({"100000"})
    private int count;


    private List<Person> persons;

    @Setup
    public void setup() {
        persons = createPersonList();
    }

    @Benchmark
    public void gsonTest() {
        for (int i = 0; i < count; ++i) {
            GsonUtils.toJson(persons);
        }
    }

    @Benchmark
    public void fastJsonTest(){
        for (int i = 0; i < count; ++i){
            FastJsonUtils.toJson(persons);
        }
    }

    @Benchmark
    public void jacksonTest() throws Exception{
        for (int i = 0; i < count; ++i){
            JacksonUtils.toJson(persons);
        }
    }

    private List<Person> createPersonList(){
        Person bob = new Person("bob", 20, "I am a joy boy.....");
        Person james = new Person("james", 20, "I am a joy boy.....");
        Person lee = new Person("lee", 20, "I am a joy boy.....");
        Person sam = new Person("sam", 20, "I am a joy boy.....");

        List<Person> list = new ArrayList<>();
        list.add(bob);
        list.add(james);
        list.add(lee);
        list.add(sam);

        return list;
    }


    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(JsonSerializeListTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
