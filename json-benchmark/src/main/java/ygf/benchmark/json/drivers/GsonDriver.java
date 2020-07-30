package ygf.benchmark.json.drivers;

import ygf.benchmark.json.beans.Person;
import ygf.benchmark.json.utils.GsonUtils;


public class GsonDriver {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("bob");
        person.setAge(20);
        person.setDesc("I am a joy boy....");

        String json = GsonUtils.toJson(person);
        System.out.println(json);

        person = (Person) GsonUtils.fromJson(json, Person.class);

        System.out.println(person);
    }
}
