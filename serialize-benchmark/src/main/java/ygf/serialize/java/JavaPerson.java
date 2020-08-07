package ygf.serialize.java;

import ygf.serialize.hessian.HessianPerson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * java person class
 *
 * @author yanggaofeng
 */
public class JavaPerson implements Serializable {
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
    private List<JavaPerson> friends;
    /**
     * relatives
     */
    private Map<String, JavaPerson> relatives;
    /**
     * hobbies
     */
    private List<String> hobbies;

    public JavaPerson(){}

    public JavaPerson(String name, Integer age, String desc){
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public JavaPerson(String name, Integer age, String desc, String hobbit){
        this.name = name;
        this.age = age;
        this.desc = desc;

        List<String> hobbies = new ArrayList<>();
        hobbies.add(hobbit);
        this.hobbies = hobbies;
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

    public List<JavaPerson> getFriends() {
        return friends;
    }

    public void setFriends(List<JavaPerson> friends) {
        this.friends = friends;
    }

    public Map<String, JavaPerson> getRelatives() {
        return relatives;
    }

    public void setRelatives(Map<String, JavaPerson> relatives) {
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

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        JavaPerson that = (JavaPerson) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(friends, that.friends) &&
                Objects.equals(relatives, that.relatives) &&
                Objects.equals(hobbies, that.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, desc, friends, relatives, hobbies);
    }

    @Override
    public String toString() {
        return "JavaPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                ", friends=" + friends +
                ", relatives=" + relatives +
                ", hobbies=" + hobbies +
                '}';
    }
}
