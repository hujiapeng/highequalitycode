package hqcode.数组和集合;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortDemo {

    @Test
    public void func(){
        List<Person> people=new ArrayList<>();
        people.add(new Person("AAA",18));
        people.add(new Person("DDD",15));
        people.add(new Person("CCC",16));
        people.add(new Person("CCC",14));

        Collections.sort(people);
//        Collections.sort(people,new PersonComparator());
        System.out.println(StringUtils.join(people,","));
    }

    class Person implements Comparable<Person>{
        private String name;
        private Integer age;

        public Person(String _name,Integer _age){
            this.name=_name;
            this.age=_age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return new CompareToBuilder().append(name,o.name).append(age,o.age).toComparison();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    class PersonComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }
}



