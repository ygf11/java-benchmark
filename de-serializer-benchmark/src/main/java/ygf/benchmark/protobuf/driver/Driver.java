package ygf.benchmark.protobuf.driver;

import static ygf.benchmark.protobuf.People.Person;
import static ygf.benchmark.protobuf.PersonUtil.build;

/**
 * protobuf driver
 *
 * @author yanggaofeng
 */
public class Driver {

    public static void main(String[] args) {
        Person person = build();

        System.out.println(person.toString());
        System.out.println(person.toByteArray().length);
    }
}
