package hqcode.泛型和反射;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class 反射Demo {

    @Test
    public void func1(){
        //类的属性class所引用的对象与实例对象的getClass返回值相同
        System.out.println(String.class.equals(new String().getClass()));
        System.out.println("ABC".getClass().equals(String.class));
        //class实例对象不区分泛型
        System.out.println(ArrayList.class.equals(new ArrayList<String>().getClass()));
    }

    @Test
    public void func2(){
        String[] strs=(String[])Array.newInstance(String.class,5);
    }

}
