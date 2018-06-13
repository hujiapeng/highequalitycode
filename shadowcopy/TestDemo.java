package hqcode.shadowcopy;

import org.junit.Test;

/**
 * Created by JiaPeng on 2018/6/11.
 */
public class TestDemo {

    @Test
    public void func() throws CloneNotSupportedException {
        Person a=new Person("a");
        Person aa=new Person("aa",a);
        Person bb= (Person) aa.clone();
        //如果Person没有重写clone方法，那么此处的bb.getParent()得到的person对象引用地址
        // 和aa.getParent()得到的person对象引用地址一样
        bb.getParent().setName("bb的Father");
        System.out.println(aa.getParent().getName());
        System.out.println(bb.getParent().getName());
    }

}
