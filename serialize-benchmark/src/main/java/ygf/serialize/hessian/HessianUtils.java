package ygf.serialize.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hessian person utils
 *
 * @author yanggaofeng
 */
public class HessianUtils {

    /**
     * serialize person
     *
     * @param person person
     * @return byte array
     */
    public static byte[] serialize(Person person) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(bos);
        byte[] data;

        out.startMessage();
        out.writeObject(person);
        out.completeMessage();
        out.close();

        data = bos.toByteArray();
        bos.close();

        return data;
    }

    /**
     * deserialize
     *
     * @param byteArray byte array
     * @return person
     */
    public static Object deserialize(byte[] byteArray) throws Exception{
        ByteArrayInputStream bin = new ByteArrayInputStream(byteArray);
        Hessian2Input input = new Hessian2Input(bin);

        Object obj = null;
        input.startMessage();

        obj = input.readObject();

        input.completeMessage();
        input.close();
        bin.close();

        return obj;
    }

    /**
     * build person
     *
     * @return person
     */
    public static Person buildHessianPerson() {
        // friends
        Person john = new Person("John", 18, "I am his friend, John.", "ping-pong");
        Person jack = new Person("Jack", 19, "I am his friend, Jack.", "tennis");
        Person theo = new Person("Theo", 20, "I am his friend, Theo.", "football");
        Person tracy = new Person("Tracy", 17, "I am his friend, Tracy.", "skiing");

        // relatives
        Person tom = new Person("Tom", 45, "I am his father, Tom.", "running");
        Person lucy = new Person("Lucy", 43, "I am his mother, Lucy.", "cooking");
        Person grace = new Person("grace", 25, "I am his old sister, Grace.", "swimming");

        // person
        Person person = new Person("Andy", 20, "I am Andy.");

        List<String> hobbies = new ArrayList<>();
        hobbies.add("football");
        hobbies.add("basketball");
        person.setHobbies(hobbies);

        List<Person> friends = new ArrayList<>();
        friends.add(john);
        friends.add(jack);
        friends.add(theo);
        friends.add(tracy);
        person.setFriends(friends);

        Map<String, Person> relatives = new HashMap<>(8);
        relatives.put("father-son", tom);
        relatives.put("mather-son", lucy);
        relatives.put("sister", grace);

        person.setRelatives(relatives);


        return person;
    }


    public static void main(String[] args) throws Exception{
        Person person = buildHessianPerson();
        byte[] array = serialize(person);

        System.out.println(array.length);

        Object obj = deserialize(array);

        System.out.println(obj);
    }
}
