package ygf.serialize.protobuf;

import static ygf.benchmark.protobuf.People.Person;

/**
 * person util
 *
 * @author yanggaofeng
 */
public class PersonUtil {

    /**
     * build person instance
     *
     * @return person
     */
    public static Person build() {
        // friends
        Person john = buildSingleInstance("John", 18, "I am his friend, John.", "ping-pong");
        Person jack = buildSingleInstance("Jack", 19, "I am his friend, Jack.", "tennis");
        Person theo = buildSingleInstance("Theo", 20, "I am his friend, Theo.", "football");
        Person tracy = buildSingleInstance("Tracy", 17, "I am his friend, Tracy.", "skiing");

        // relatives
        Person tom = buildSingleInstance("Tom", 45, "I am his father, Tom.", "running");
        Person lucy = buildSingleInstance("Lucy", 43, "I am his mother, Lucy.", "cooking");
        Person grace = buildSingleInstance("grace",
                25, "I am his old sister, Grace.", "swimming");

        return Person.newBuilder()
                .setName("Andy")
                .setAge(20)
                .setDesc("I am Andy.")
                .addHobbit("football")
                .addHobbit("basketball")
                .addFriend(john)
                .addFriend(jack)
                .addFriend(theo)
                .addFriend(tracy)
                .putRelations("father-son", tom)
                .putRelations("mather-son", lucy)
                .putRelations("sister", grace)
                .build();


    }

    /**
     * build single person
     *
     * @param name  name
     * @param age   age
     * @param desc  desc
     * @return person
     */
    private static Person buildSingleInstance(String name, Integer age, String desc, String hobbit) {
        return Person.newBuilder()
                .setName(name)
                .setAge(age)
                .setDesc(desc)
                .addHobbit(hobbit)
                .build();
    }
}
