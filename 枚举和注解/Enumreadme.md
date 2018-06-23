1. 使用枚举定义常量
2. 小心Switch判断枚举时，传入null，抛出空指针异常
    <pre>
    public enum Season {
        Spring,Summer,Autum,Winter;        
        public static Season getComfortableSeason(){
            return Spring;
        }
    }
    ·······
    public void testFunc(Season season){
        switch(season){
            case Spring:
                System.out.println(Season.Spring);
            ······
        }
    }
    ······
    piblic static void main(String[] args){
        testFunc(null);//会抛出空指针异常
    }
    </pre>
  switch语句先计算season变量的排序值，然后与枚举常量的每个排序值进行对比，上面的switch语句等同于下面：
    <pre>
    switch(season.ordinal()){
        case Season.Spring.ordinal():
            ······ 
    }
    </pre>
3. 枚举类通过使用valueOf方法转换字符串为枚举对象，如果转换一个不存在的而失败则抛出IllegalArgumentException异常，下面方法无法继续进行。（注意valueOf方法是JVM内置方法，不可见）
    <pre>
    public void func(){
        //小写的spring导致转换失败
        System.out.println(Season.valueOf("spring"));
        System.out.println("如果上面抛出异常，这句不执行");
    }
    </pre>
异常处理方式：<p>1）、使用try···catch捕获处理<pre>
    public void func3(){
        try {
            System.out.println(Season.valueOf("spring"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("下方代码可执行");
    }
</pre></p><p>2）、扩展枚举类，写一个contains方法，先判断再使用，示例如下<pre>
    public static boolean contains(String name) {
        Season[] seasons = values();
        for (Season season : seasons) {
            if (season.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
</pre></p>
4. 枚举实现工厂方法<p>1）、非静态方法实现：<pre>
    public enum CarFactory {
        FordCar,BuickCar;
        //生产汽车
        public Car create() {
            switch (this) {
                case FordCar:
                    return new FordCar();
                case BuickCar:
                    return new BuickCar();
                default:
                    throw new AssertionError("无效参数");
            }
        }
    }
</pre></p><p>2）、抽象方法实现：<pre>
    public enum CarFactory {
        //定义工厂能生产的汽车类型
        FordCar {
            @Override
            public Car create() {
                return new FordCar();
            }
        }, BuickCar {
            @Override
            public Car create() {
                return new BuickCar();
            }
        };
        public abstract Car create();
    }
</pre></p>Car是接口，FoldCar和BuickCar是其实现类
5. 枚举项数不超过64：EnumSet.allOf(Season.class)将枚举转为EnumSet，如果Season枚举成员数小于等于64，则使用RegularEnumSet，如果大于则使用JumboEnumSet，JumboEnumSet会根据枚举成员数量，先按照64个一组进行拆分，然后每个组再映射到一个long类型数字的每个位上。所以枚举成员数量不超过64时，性能极佳