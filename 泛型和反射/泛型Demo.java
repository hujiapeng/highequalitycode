package hqcode.泛型和反射;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 泛型Demo {

    @Test
    public void test() {
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        System.out.println(strList.getClass() == intList.getClass());//输出true
    }

//    private void func(List<String> strList){
//
//    }
//    private void func(List<Integer> strList){
//
//    }

//    private void func() {
//        String[] strArr = new String[5];//编译不报错
//        List<Integer>[] intListArr;//编译不报错
//        List<String>[] strListArr = new ArrayList<String>[5];//编译报错，类型擦除List<String>[]和List<Object>[]是同一回事，编译器拒绝如此声明
//    }

//    @Test
//    public void func(){
//        List<String> list=new ArrayList<>();
//        System.out.println(list instanceof List);//输出true
//        System.out.println(list instanceof List<String>);//编译出错，由于类型擦除，instanceof不允许存在泛型参数
//    }

}
