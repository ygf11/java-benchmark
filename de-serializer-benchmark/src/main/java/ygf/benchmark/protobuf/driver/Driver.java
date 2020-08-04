package ygf.benchmark.protobuf.driver;

import static ygf.benchmark.protobuf.People.Person;

/**
 * protobuf driver
 *
 * @author yanggaofeng
 */
public class Driver {

    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setName("ygf")
                .setAge(18)
                .setDesc("test")
                .addFriend(Person.newBuilder()
                        .setName("y1")
                        .setAge(20)
                        .setDesc("test")
                        .build())
                .build();

        System.out.println(person.toString());
        System.out.println(person.toByteArray().length);
    }
}
