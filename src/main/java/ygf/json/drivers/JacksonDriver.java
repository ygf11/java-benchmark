package ygf.json.drivers;

import ygf.json.beans.Person;
import ygf.json.utils.JacksonUtils;

public class JacksonDriver {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("bob");
        person.setAge(20);
        person.setDesc("I am a joy boy....");

        String json = JacksonUtils.toJson(person);
        System.out.println(json);

        person = (Person) JacksonUtils.fromJson(json, Person.class);

        System.out.println(person);
    }
}
