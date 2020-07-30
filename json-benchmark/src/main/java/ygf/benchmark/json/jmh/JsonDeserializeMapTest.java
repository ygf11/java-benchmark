package ygf.benchmark.json.jmh;

import com.alibaba.fastjson.TypeReference;
import com.google.gson.reflect.TypeToken;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ygf.benchmark.json.beans.Person;
import ygf.benchmark.json.utils.FastJsonUtils;
import ygf.benchmark.json.utils.GsonUtils;
import ygf.benchmark.json.utils.JacksonUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonDeserializeMapTest {
    @Param({"1000000"})
    private int count;


    private String persons;

    @Setup
    public void setup() {
        persons = createPersonMap();
    }

    @Benchmark
    public void gsonTest() {
        for (int i = 0; i < count; ++i) {
            Type type = new TypeToken<Map<String, Person>>(){}.getType();
            GsonUtils.fromJson(persons, type);
        }
    }

    @Benchmark
    public void fastJsonTest() {
        for (int i = 0; i < count; ++i) {
            TypeReference type = new TypeReference<Map<String,Person>>(){};
            FastJsonUtils.fromJson(persons, type);
        }
    }

    @Benchmark
    public void jacksonTest() throws Exception {
        for (int i = 0; i < count; ++i) {
            com.fasterxml.jackson.core.type.TypeReference type =
                    new com.fasterxml.jackson.core.type.TypeReference<Map<String,Person>>() {};
            JacksonUtils.fromJson(persons, type);
        }
    }

    private String createPersonMap() {
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
        return GsonUtils.toJson(map);
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(JsonDeserializeMapTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
