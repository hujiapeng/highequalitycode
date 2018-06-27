package hqcode.枚举和注解.枚举;

import org.junit.Test;

public class EnumTestDemo {

    @Test
    public void func(){
        System.out.println(Season.getComfortableSeason().equals(Season.Spring));//true
        System.out.println(Season.getComfortableSeason());//输出：Spring
    }

    @Test
    public void func1(){
        System.out.println(Role.Admin.getLifeTime());
    }

    private void testFunc(Season season){
        switch(season){
            case Spring:
                System.out.println(Season.Spring);
        }
    }

    @Test
    public void func2(){
        System.out.println(Season.valueOf("spring"));
        System.out.println("如果上面抛出异常，这句不执行");
    }

    @Test
    public void func3(){
        try {
            System.out.println(Season.valueOf("spring"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("下方代码可执行");
    }



}
