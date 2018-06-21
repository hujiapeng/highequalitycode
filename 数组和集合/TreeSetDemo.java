package hqcode.数组和集合;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.Collator;
import java.util.*;

public class TreeSetDemo {

    @Test
    public void func(){
        TreeSet<Integer> integerTreeSet=new TreeSet<>();
        integerTreeSet.add(9);
        integerTreeSet.add(8);
        integerTreeSet.add(7);
        integerTreeSet.add(6);

        System.out.println(StringUtils.join(integerTreeSet));
        //获取第二大值
        System.out.println(integerTreeSet.lower(integerTreeSet.last()));;

        //Person一定要实现Comparable接口,TreeSet根据compareTo返回值判断是否为同一对象
        TreeSet<Person> personTreeSet=new TreeSet<>();
        personTreeSet.add(new Person("张三",20));
        personTreeSet.add(new Person("赵四",19));
        personTreeSet.add(new Person("李四",20));
        personTreeSet.add(new Person("王五",19));

        System.out.println(StringUtils.join(personTreeSet));//打印[Person{name='赵四', age=19}, Person{name='张三', age=20}]

        List<Person> people=new ArrayList<>();
        people.add(new Person("张三",20));
        people.add(new Person("赵四",19));
        people.add(new Person("李四",20));
        people.add(new Person("王五",19));
        //Collection对list排序，set不行
        Collections.sort(people,new PersonComparator());
        System.out.println(StringUtils.join(people));
    }

}

class Person implements Comparable{
   private String name;
   private int age;


   public Person(String _name,int _age){
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
       Person person= (Person) o;
        return this.age-person.getAge();
    }
}

class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        Collator collator=Collator.getInstance(Locale.CHINA);
        String[] names={o1.getName(),o2.getName()};
        Arrays.sort(names);
        return o1.getName().equalsIgnoreCase(names[0])?1:-1;
    }
}
