package ygf.serialize.hessian;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * hessian person pojo
 *
 * @author yanggaofeng
 */
public class Person implements Serializable {
    /**
     * name
     */
    private String name;
    /**
     * age
     */
    private Integer age;
    /**
     * desc
     */
    private String desc;
    /**
     * friend list
     */
    private List<Person> friends;
    /**
     * relatives
     */
    private List<Person> relatives;
    /**
     * hobbies
     */
    private List<String> hobbies;

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

    public List<Person> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Person> relatives) {
        this.relatives = relatives;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(desc, person.desc) &&
                Objects.equals(friends, person.friends) &&
                Objects.equals(relatives, person.relatives) &&
                Objects.equals(hobbies, person.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, desc, friends, relatives, hobbies);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                ", friends=" + friends +
                ", relatives=" + relatives +
                ", hobbies=" + hobbies +
                '}';
    }
}
