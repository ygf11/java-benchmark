package ygf.serialize.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

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



    public static void main(String[] args){
        Person person = new Person();
        person.setName("test");
        person.setAge(18);
        person.setDesc("test");

        byte[] array = serialize(person);

        System.out.println(array.length);

        Object obj = deserialize(array);

        System.out.println(obj);
    }
}
