package ygf.json;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ygf.json.beans.Person;
import ygf.json.utils.FastJsonUtils;
import ygf.json.utils.GsonUtils;
import ygf.json.utils.JacksonUtils;

@RunWith(JUnit4.class)
public class JsonTest {

    private Person person;

    private String json;

    @Before
    public void setup(){
        person = new Person();
        person.setName("bob");
        person.setAge(20);
        person.setDesc("I am a joy boy...");

        json = GsonUtils.toJson(person);
    }

    @Test
    public void gsonTest(){
        Assert.assertEquals(person, GsonUtils.fromJson(json, Person.class));
    }


    @Test
    public void FastjsonTest(){
        Assert.assertEquals(person, FastJsonUtils.fromJson(json, Person.class));
    }

    @Test
    public void JacksonTest() throws Exception{
        Assert.assertEquals(person, JacksonUtils.fromJson(json, Person.class));
    }
}
