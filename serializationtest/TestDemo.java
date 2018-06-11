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

        SerializationUtils.writeObject(person,"person");
    }

    @Test
    public void consumer(){
        Person person= (Person) SerializationUtils.readObject("person");
        System.out.println(person);
    }

    @Test
    public void serializeCourse(){
        Course course=new Course();
        course.setName("数学");
        course.setScore(90);
        SerializationUtils.writeObject(course,"course");
    }

    @Test
    public void deserializeCourse(){
        Course course= (Course) SerializationUtils.readObject("course");
        System.out.println(course);
    }

}
