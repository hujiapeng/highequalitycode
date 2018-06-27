package hqcode.枚举和注解.注解;

import org.junit.Test;

public class AnnotationTestDemo {

    @Test
    public void func(){
        Bird bird=BirdNest.Sparrow.reproduce();
        Desc.Color color=bird.getColor();
        System.out.println(color);
    }

}
