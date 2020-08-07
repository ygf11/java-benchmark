package ygf.serialize.hessian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * hessian person pojo
 *
 * @author yanggaofeng
 */
public class HessianPerson implements Serializable {
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
    private List<HessianPerson> friends;
    /**
     * relatives
     */
    private Map<String, HessianPerson> relatives;
    /**
     * hobbies
     */
    private List<String> hobbies;

    public HessianPerson(){ }

    public HessianPerson(String name, Integer age, String desc){
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public HessianPerson(String name, Integer age, String desc, String hobbit){
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

    public List<HessianPerson> getFriends() {
        return friends;
    }

    public void setFriends(List<HessianPerson> friends) {
        this.friends = friends;
    }

    public Map<String, HessianPerson> getRelatives() {
        return relatives;
    }

    public void setRelatives(Map<String, HessianPerson> relatives) {
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

        HessianPerson hessianPerson = (HessianPerson) o;
        return Objects.equals(name, hessianPerson.name) &&
                Objects.equals(age, hessianPerson.age) &&
                Objects.equals(desc, hessianPerson.desc) &&
                Objects.equals(friends, hessianPerson.friends) &&
                Objects.equals(relatives, hessianPerson.relatives) &&
                Objects.equals(hobbies, hessianPerson.hobbies);
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
