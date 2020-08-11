package ygf.serialize.avro;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.compress.utils.Lists;
import ygf.benchmark.protobuf.People;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * avro person utils
 *
 * @author yanggaofeng
 */
public class AvroPersonUtils {

    public static byte[] serialize(AvroPerson person){
        byte[] data;
        try {
            DatumWriter<AvroPerson> datumWriter = new SpecificDatumWriter<>(AvroPerson.class);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BinaryEncoder binaryEncoder = EncoderFactory.get().directBinaryEncoder(outputStream, null);
            datumWriter.write(person, binaryEncoder);
            data = outputStream.toByteArray();
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
            data = null;
        }
        return data;
    }

    public static AvroPerson deserialize(byte[] data){
        return null;
    }

    public static AvroPerson build(){
        // friends
        AvroPerson john = buildAvroPerson("John", 18, "I am his friend, John.", "ping-pong");
        AvroPerson jack = buildAvroPerson("Jack", 19, "I am his friend, Jack.", "tennis");
        AvroPerson theo = buildAvroPerson("Theo", 20, "I am his friend, Theo.", "football");
        AvroPerson tracy = buildAvroPerson("Tracy", 17, "I am his friend, Tracy.", "skiing");

        // relatives
        AvroPerson tom = buildAvroPerson("Tom", 45, "I am his father, Tom.", "running");
        AvroPerson lucy = buildAvroPerson("Lucy", 43, "I am his mother, Lucy.", "cooking");
        AvroPerson grace = buildAvroPerson("grace",
                25, "I am his old sister, Grace.", "swimming");

        AvroPerson person = new AvroPerson();
        person.setName("Andy");
        person.setAge(20);
        person.setDesc("I am Andy.");

        List<CharSequence> hobbies = new ArrayList<>();
        hobbies.add("football");
        hobbies.add("basketball");
        person.setHobbies(hobbies);

        List<AvroPerson> friends = new ArrayList<>();
        friends.add(john);
        friends.add(jack);
        friends.add(theo);
        friends.add(tracy);
        person.setFriends(friends);

        Map<CharSequence, AvroPerson> relatives = new HashMap<>(16);
        relatives.put("father-son", tom);
        relatives.put("mother-son", lucy);
        relatives.put("sister", grace);

        person.setRelatives(relatives);
        return person;
    }

    public static AvroPerson buildAvroPerson(String name, Integer age, String desc, String hobbit){
        AvroPerson person = new AvroPerson();
        person.setAge(age);
        person.setName(name);
        person.setDesc(desc);

        List<CharSequence> hobbies = new ArrayList<>();
        hobbies.add(hobbit);
        person.setHobbies(hobbies);

        return person;
    }


    public static void main(String[] args){


        System.out.println(serialize(build()).length);
    }


}
