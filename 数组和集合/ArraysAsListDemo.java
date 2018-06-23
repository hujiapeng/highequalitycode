package hqcode.数组和集合;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ArraysAsListDemo {

    @Test
    public void func(){
        int[] intArr={1,2,3,4};
        //基本类型不能泛型化
        System.out.println(Arrays.asList(intArr).size());

        Integer[] integerArr={1,2,3,4};

        System.out.println(Arrays.asList(integerArr).size());

        Student[] studentArr={new Student("小明",20),new Student("小红",18)};

        System.out.println(Arrays.asList(studentArr).size());
        List studentList=Arrays.asList(studentArr);

        //下面add方法会抛出UnsupportedOperationException异常，因为Arrays.asList返回的ArrayList是Arrays内部类，没有add方法，
        //此异常是其父类add方法抛出的；我们平常用的ArrayList类是java.util.ArrayList
        studentList.add(new Student("小亮",21));

    }

}

class Student {
    private String name;
    private int age;


    public Student(String _name,int _age){
        this.name=_name;
        this.age=_age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
