package ygf.json.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ygf.json.beans.Person;
import ygf.json.utils.FastJsonUtils;
import ygf.json.utils.GsonUtils;
import ygf.json.utils.JacksonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonSerializeMapTest {

    @Param({"100000"})
    private int count;


    private Map<String, Person> persons;

    @Setup
    public void setup() {
        persons = createPersonMap();
    }

    @Benchmark
    public void gsonTest() {
        for (int i = 0; i < count; ++i) {
            GsonUtils.toJson(persons);
        }
    }

    @Benchmark
    public void fastJsonTest() {
        for (int i = 0; i < count; ++i) {
            FastJsonUtils.toJson(persons);
        }
    }

    @Benchmark
    public void jscksonTest() throws Exception {
        for (int i = 0; i < count; ++i) {
            JacksonUtils.toJson(persons);
        }
    }

    private Map<String, Person> createPersonMap() {
        Person bob = new Person("bob", 20, "I am a joy boy.....");
        Person james = new Person("james", 20, "I am a joy boy.....");
        Person lee = new Person("lee", 20, "I am a joy boy.....");
        Person sam = new Person("sam", 20, "I am a joy boy.....");
        Person linx = new Person("linx", 20, "I am a joy boy.....");

        Map<String, Person> map = new HashMap<>();
        map.put("bob",bob);
        map.put("james",james);
        map.put("lee", lee);
        map.put("sam", sam);
        map.put("linx", linx);
        map.put("bob1", bob);
        map.put("james1", james);
        return map;
    }


    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(JsonSerializeMapTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
