package ygf.serialize.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * person utils
 *
 * @author yanggaofeng
 */
public class JavaPersonUtils {
    /**
     * serialize
     *
     * @param person person
     * @return byte array
     */
    public static byte[] serialize(JavaPerson person) {
        byte[] data;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);) {
            oos.writeObject(person);
            data = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            data = null;
        }

        return data;
    }

    /**
     * deserialize
     *
     * @param data data
     * @return person
     */
    public static JavaPerson deserialize(byte[] data) {
        Object person;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis);) {
             person = ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            person = null;
        }

        return (JavaPerson) person;
    }

    /**
     * build person
     *
     * @return person
     */
    public static JavaPerson buildPerson(){
        // friends
        JavaPerson john = new JavaPerson("John", 18, "I am his friend, John.", "ping-pong");
        JavaPerson jack = new JavaPerson("Jack", 19, "I am his friend, Jack.", "tennis");
        JavaPerson theo = new JavaPerson("Theo", 20, "I am his friend, Theo.", "football");
        JavaPerson tracy = new JavaPerson("Tracy", 17, "I am his friend, Tracy.", "skiing");

        // relatives
        JavaPerson tom = new JavaPerson("Tom", 45, "I am his father, Tom.", "running");
        JavaPerson lucy = new JavaPerson("Lucy", 43, "I am his mother, Lucy.", "cooking");
        JavaPerson grace = new JavaPerson("grace", 25, "I am his old sister, Grace.", "swimming");

        // person
        JavaPerson hessianPerson = new JavaPerson("Andy", 20, "I am Andy.");

        List<String> hobbies = new ArrayList<>();
        hobbies.add("football");
        hobbies.add("basketball");
        hessianPerson.setHobbies(hobbies);

        List<JavaPerson> friends = new ArrayList<>();
        friends.add(john);
        friends.add(jack);
        friends.add(theo);
        friends.add(tracy);
        hessianPerson.setFriends(friends);

        Map<String, JavaPerson> relatives = new HashMap<>(8);
        relatives.put("father-son", tom);
        relatives.put("mather-son", lucy);
        relatives.put("sister", grace);

        hessianPerson.setRelatives(relatives);


        return hessianPerson;
    }

    public static void main(String[] args){
        JavaPerson person = buildPerson();

        byte[] array = serialize(person);
        System.out.println(array.length);
        System.out.println(deserialize(array));
    }
}
