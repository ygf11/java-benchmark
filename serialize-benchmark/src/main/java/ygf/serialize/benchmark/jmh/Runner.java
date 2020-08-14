package ygf.serialize.benchmark.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ygf.benchmark.protobuf.People;
import ygf.serialize.avro.AvroPerson;
import ygf.serialize.avro.AvroPersonUtils;
import ygf.serialize.hessian.HessianPerson;
import ygf.serialize.hessian.HessianUtils;
import ygf.serialize.java.JavaPerson;
import ygf.serialize.java.JavaPersonUtils;
import ygf.serialize.json.JacksonUtils;
import ygf.serialize.protobuf.PersonUtil;

import java.util.concurrent.TimeUnit;

/**
 * de-serializer jmh benchmark
 *
 * @author yanggaofeng
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Runner {

    @Param({"1000000"})
    private int count;

    public static void printSerializeSize() {
        People.Person person = PersonUtil.build();
        HessianPerson hessianPerson = HessianUtils.buildHessianPerson();

        JavaPerson javaPerson = JavaPersonUtils.buildPerson();

        AvroPerson avroPerson = AvroPersonUtils.build();

        System.out.println("proto buf size:" +
                person.toByteArray().length);

        System.out.println("hessian size:" +
                HessianUtils.serialize(hessianPerson).length);

        System.out.println("java size:" +
                JavaPersonUtils.serialize(javaPerson).length);

        System.out.println("jackson size:" +
                JacksonUtils.serialize(javaPerson).length);

        System.out.println("avro size:" +
                AvroPersonUtils.serialize(avroPerson).length);
    }

    @Benchmark
    public void protoBufSerializerBench() {
        People.Person person = PersonUtil.build();
        for (int i = 0; i < count; ++i) {
            person.toByteArray();
        }
    }

    @Benchmark
    public void protoBufDeserializerBench() throws Exception {
        People.Person person = PersonUtil.build();
        byte[] byteArray = person.toByteArray();
        for (int i = 0; i < count; ++i) {
            People.Person.parseFrom(byteArray);
        }
    }

    @Benchmark
    public void hessianSerializerBench() {
        HessianPerson hessianPerson = HessianUtils.buildHessianPerson();
        for (int i = 0; i < count; ++i) {
            HessianUtils.serialize(hessianPerson);
        }
    }

    @Benchmark
    public void hessianDeserializerBench() {
        HessianPerson hessianPerson = HessianUtils.buildHessianPerson();
        byte[] byteArray = HessianUtils.serialize(hessianPerson);
        for (int i = 0; i < count; ++i) {
            HessianUtils.deserialize(byteArray);
        }
    }

    @Benchmark
    public void javaSerializerBench() {
        JavaPerson javaPerson = JavaPersonUtils.buildPerson();
        for (int i = 0; i < count; ++i) {
            JavaPersonUtils.serialize(javaPerson);
        }
    }

    @Benchmark
    public void javaDeserializerBench() {
        JavaPerson javaPerson = JavaPersonUtils.buildPerson();
        byte[] byteArray = JavaPersonUtils.serialize(javaPerson);
        for (int i = 0; i < count; ++i) {
            JavaPersonUtils.deserialize(byteArray);
        }
    }

    @Benchmark
    public void jacksonSerializerBench() {
        JavaPerson javaPerson = JavaPersonUtils.buildPerson();
        for (int i = 0; i < count; ++i) {
            JacksonUtils.serialize(javaPerson);
        }
    }

    @Benchmark
    public void jacksonDeserializerBench() {
        JavaPerson javaPerson = JavaPersonUtils.buildPerson();
        byte[] byteArray = JacksonUtils.serialize(javaPerson);
        for (int i = 0; i < count; ++i) {
            JacksonUtils.deserialize(byteArray, JavaPerson.class);
        }
    }

    @Benchmark
    public void avroSerializerBench(){
        AvroPerson avroPerson = AvroPersonUtils.build();
        for (int i = 0; i < count; ++i){
            AvroPersonUtils.serialize(avroPerson);
        }
    }

    @Benchmark
    public void avroDeserializerBench()  {
        AvroPerson avroPerson = AvroPersonUtils.build();
        byte[] byteArray = AvroPersonUtils.serialize(avroPerson);
        for (int i = 0; i < count; ++i) {
            AvroPersonUtils.deserialize(byteArray);
        }
    }


    public static void main(String[] args) throws Exception {
        printSerializeSize();

        Options options = new OptionsBuilder()
                .include(Runner.class.getSimpleName())
                .forks(1)
                .build();
        new org.openjdk.jmh.runner.Runner(options).run();
    }
}
