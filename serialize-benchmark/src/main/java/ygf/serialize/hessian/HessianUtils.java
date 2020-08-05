package ygf.serialize.hessian;

import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
    public static byte[] serialize(Person person) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(bos);
        byte[] data = null;

        try {
            out.startMessage();
            out.writeObject(person);
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

    public static void main(String[] args){
        Person person = new Person();
        person.setName("test");
        person.setAge(18);
        person.setDesc("test");

        byte[] array = serialize(person);

        System.out.println(array.length);
    }
}
