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
import ygf.benchmark.protobuf.PersonUtil;
import ygf.serialize.hessian.HessianUtils;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import static ygf.serialize.hessian.HessianUtils.serialize;

/**
 * de-serializer jmh benchmark
 *
 * @author yanggaofeng
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Runner {

    @Param({"10"})
    private int count;

    public static void printSerializeSize() throws Exception{
        People.Person person = PersonUtil.build();
        ygf.serialize.hessian.Person hessianPerson =
                ygf.serialize.hessian.HessianUtils.buildHessianPerson();

        System.out.println("proto buf size:" + person.toByteArray().length);
        System.out.println("hessian size:" + serialize(hessianPerson).length);
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
            People.Person data = People.Person.parseFrom(byteArray);
            assert Objects.equals(data, person);
        }
    }

    @Benchmark
    public void hessianSerializerBench() throws Exception{
        ygf.serialize.hessian.Person person = ygf.serialize.hessian.HessianUtils.buildHessianPerson();
        for (int i = 0; i < count; ++i){
            ygf.serialize.hessian.HessianUtils.serialize(person);
        }
    }

    @Benchmark
    public void hessianDeserializerBench() throws Exception{
        ygf.serialize.hessian.Person person = ygf.serialize.hessian.HessianUtils.buildHessianPerson();
        byte[] byteArray = ygf.serialize.hessian.HessianUtils.serialize(person);
        for (int i = 0; i < count; ++i) {
            Object data = ygf.serialize.hessian.HessianUtils.deserialize(byteArray);
            assert Objects.equals(data, person);
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
