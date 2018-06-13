package hqcode.serializecopy;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

/**
 * Created by JiaPeng on 2018/6/13.
 */
public class TestDemo {

    @Test
    public void func(){
        Person p1=new Person("p1");
        Person p2=new Person("p2",p1);
        Person p3=CloneUtils.clone(p2);
        p3.getParent().setName("p4");
        System.out.println(p2.getParent().getName());
        System.out.println(p3.getParent().getName());
    }

    @Test
    public void func1(){
        Person p1=new Person("p1");
        Person p2=new Person("p2",p1);
        Person p3=SerializationUtils.clone(p2);
        p3.getParent().setName("p4");
        System.out.println(p2.getParent().getName());
        System.out.println(p3.getParent().getName());
    }


}
