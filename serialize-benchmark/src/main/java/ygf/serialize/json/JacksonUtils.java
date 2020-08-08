package ygf.serialize.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ygf.serialize.java.JavaPerson;

import java.io.IOException;

/**
 * jackson utils
 *
 * @author yanggaofeng
 */
public class JacksonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static byte[] serialize(JavaPerson person) {
        byte[] data = null;
        try {
            data = OBJECT_MAPPER.writeValueAsBytes(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static JavaPerson deserialize(byte[] data, Class<?> cz) {
        JavaPerson person;
        try {
            person = (JavaPerson) OBJECT_MAPPER.readValue(data, cz);
        } catch (IOException e) {
            e.printStackTrace();
            person = null;
        }

        return person;
    }
}
