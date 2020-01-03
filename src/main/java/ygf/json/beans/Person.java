package ygf.json.beans;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String name;

    private Integer age;

    private String desc;

    private List<Person> friends;

    private Map<String, Person> relations;

    private List<String> hobbies;

    public Person(){

    }

    public Person(String name, Integer age, String desc){
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public Map<String, Person> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, Person> relations) {
        this.relations = relations;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(desc, person.desc) &&
                Objects.equals(friends, person.friends) &&
                Objects.equals(relations, person.relations) &&
                Objects.equals(hobbies, person.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, desc, friends, relations, hobbies);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                ", friends=" + friends +
                ", relations=" + relations +
                ", hobbies=" + hobbies +
                '}';
    }
}
