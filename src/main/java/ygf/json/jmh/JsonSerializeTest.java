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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonSerializeTest {

    @Param({"1000000"})
    private int count;


    private Person person;

    @Setup
    public void setup() {
        person = createPerson();
    }

    @Benchmark
    public void gsonTest() {
        for (int i = 0; i < count; ++i) {
            GsonUtils.toJson(person);
        }
    }

    @Benchmark
    public void fastJsonTest(){
        for (int i = 0; i < count; ++i){
            FastJsonUtils.toJson(person);
        }
    }

    @Benchmark
    public void jscksonTest() throws Exception{
        for (int i = 0; i < count; ++i){
            JacksonUtils.toJson(person);
        }
    }

    private Person createPerson() {
        Person person = new Person();
        person.setName("bob");
        person.setAge(20);
        person.setDesc("I am a joy boy....");

/*
        Person bob = newPerson("bob");
        Person james = newPerson("james");
        Person abc = newPerson("abc");

        Map<String, Person> relations = new HashMap<>(4);
        relations.put("bob", bob);
        relations.put("james", james);
        relations.put("abc", abc);

        person.setRelations(relations);

        List<Person> friends = new ArrayList<>();
        friends.add(bob);
        friends.add(james);
        friends.add(abc);

        person.setFriends(friends);

 */

        return person;
    }

    private Person newPerson(String name){
        Person p = new Person();
        p.setName(name);
        p.setAge(20);
        p.setDesc("I am a sad boy....");

        List<String> hobbies = new ArrayList<>();
        hobbies.add("football");
        hobbies.add("basketball");
        hobbies.add("running");
        hobbies.add("jump");
        p.setHobbies(hobbies);

        p.setFriends(new ArrayList<>());
        p.setRelations(new HashMap<>(4));

        return p;
    }


    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(JsonSerializeTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
