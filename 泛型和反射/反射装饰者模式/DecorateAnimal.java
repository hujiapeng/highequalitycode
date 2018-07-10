package hqcode.泛型和反射.反射装饰者模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class DecorateAnimal implements Animal {
    //被包装的动物
    private Animal animal;
    //使用哪一个包装器
    private Class<? extends Feature> cls;
    public DecorateAnimal(Animal _animal,Class<? extends Feature> _cls){
        this.animal=_animal;
        this.cls=_cls;
    }
    @Override
    public void doStuff() {
        ClassLoader classLoader=getClass().getClassLoader();
        Feature proxy= (Feature) Proxy.newProxyInstance(classLoader, cls.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj=null;
                if(Modifier.isPublic(method.getModifiers())){
                    obj=method.invoke(cls.newInstance(),args);
                }
                animal.doStuff();
                return obj;
            }
        });
        proxy.load();
    }
}
