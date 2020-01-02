package ygf.json.drivers;

import ygf.json.beans.Person;
import ygf.json.utils.GsonUtils;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("bob");
        person.setAge(20);
        person.setBirthday(new Date());

        String json = GsonUtils.toJson(person);
        System.out.println(json);

        person = (Person) GsonUtils.fromJson(json, Person.class);

        System.out.println(person);
    }
}
