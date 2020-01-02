package ygf.json.jmh;


import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class JsonSerializeTest {

    @Param("100")
    private int count;

    @Benchmark
    public void gsonTest() {
        for (int i = 0; i < count; ++i) {

        }
    }




}
