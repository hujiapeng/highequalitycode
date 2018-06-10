package hqcode.serializationtest;

import org.junit.Test;

/**
 * Created by JiaPeng on 2018/6/8.
 */
public class TestDemo {

    @Test
    public void producer(){
        Person person=new Person();
        person.setName("混世魔王");

        SerializationUtils.writeObject(person);
    }

    @Test
    public void consumer(){
        Person person= (Person) SerializationUtils.readObject();
        System.out.println(person);
    }

}
