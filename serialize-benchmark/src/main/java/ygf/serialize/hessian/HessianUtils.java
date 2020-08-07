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
     * @param hessianPerson person
     * @return byte array
     */
    public static byte[] serialize(HessianPerson hessianPerson) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(bos);
        byte[] data = null;

        try {
            out.startMessage();
            out.writeObject(hessianPerson);
            out.completeMessage();
            out.close();

            data = bos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return data;
    }

    /**
     * deserialize
     *
     * @param byteArray byte array
     * @return person
     */
    public static Object deserialize(byte[] byteArray){
        ByteArrayInputStream bin = new ByteArrayInputStream(byteArray);
        Hessian2Input input = new Hessian2Input(bin);

        Object obj = null;
        try {
            input.startMessage();

            obj = input.readObject();

            input.completeMessage();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                input.close();
                bin.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return obj;
    }

    /**
     * build person
     *
     * @return person
     */
    public static HessianPerson buildHessianPerson(){
        // friends
        HessianPerson john = new HessianPerson("John", 18, "I am his friend, John.", "ping-pong");
        HessianPerson jack = new HessianPerson("Jack", 19, "I am his friend, Jack.", "tennis");
        HessianPerson theo = new HessianPerson("Theo", 20, "I am his friend, Theo.", "football");
        HessianPerson tracy = new HessianPerson("Tracy", 17, "I am his friend, Tracy.", "skiing");

        // relatives
        HessianPerson tom = new HessianPerson("Tom", 45, "I am his father, Tom.", "running");
        HessianPerson lucy = new HessianPerson("Lucy", 43, "I am his mother, Lucy.", "cooking");
        HessianPerson grace = new HessianPerson("grace", 25, "I am his old sister, Grace.", "swimming");

        // person
        HessianPerson hessianPerson = new HessianPerson("Andy", 20, "I am Andy.");

        List<String> hobbies = new ArrayList<>();
        hobbies.add("football");
        hobbies.add("basketball");
        hessianPerson.setHobbies(hobbies);

        List<HessianPerson> friends = new ArrayList<>();
        friends.add(john);
        friends.add(jack);
        friends.add(theo);
        friends.add(tracy);
        hessianPerson.setFriends(friends);

        Map<String, HessianPerson> relatives = new HashMap<>(8);
        relatives.put("father-son", tom);
        relatives.put("mather-son", lucy);
        relatives.put("sister", grace);

        hessianPerson.setRelatives(relatives);


        return hessianPerson;
    }



    public static void main(String[] args){
        HessianPerson hessianPerson = buildHessianPerson();
        byte[] array = serialize(hessianPerson);

        System.out.println(array.length);

        Object obj = deserialize(array);

        System.out.println(obj);
    }
}
