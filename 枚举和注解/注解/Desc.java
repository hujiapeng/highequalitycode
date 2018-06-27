package hqcode.枚举和注解.注解;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Desc {
    enum Color{
        White,Grayish,Yellow;
    }
    //默认颜色是白色
    Color c() default Color.White;
}


