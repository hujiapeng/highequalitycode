package hqcode.泛型和反射.反射;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void main(String[] args){
        Subject subject=new RealSubject();
        InvocationHandler handler=new SubjectHandler(subject);
        ClassLoader classLoader=subject.getClass().getClassLoader();
        Subject proxy= (Subject) Proxy.newProxyInstance(classLoader,subject.getClass().getInterfaces(),handler);
        proxy.request();
    }

}
