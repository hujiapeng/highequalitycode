1. @Inherited注解表示注解可以自动被继承：<pre>
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Desc {
    enum Color{
        White,Grayish,Yellow;
    }
    //默认颜色是白色
    Color c() default Color.White;
}<br/>
@Desc(c=Desc.Color.White)
class Bird{
}<br/>
class Sparrow extends Bird{
}
</pre>由于@Desc注解上使用了Inherited，所以父类使用了注解@Desc的话，子类Sparrow会自动继承注解@Desc
2. 枚举和注解结合使用：<br>
    <pre>
    public interface Identifier {
        String REFUSE_WORD="您无权访问";
        public boolean identify();
    }

    public enum CommonIdentifier implements Identifier {
        Reader,Author,Admin;
        @Override
        public boolean identify() {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Access {
        CommonIdentifier level() default CommonIdentifier.Admin;
    }

    @Access(level = CommonIdentifier.Author)
    public class Foo {
    }
    </pre>
