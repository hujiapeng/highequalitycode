package hqcode.泛型和反射.反射;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {
    private Subject subject;

    public SubjectHandler(Subject _subject){
        this.subject=_subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("预处理");
        Object obj=method.invoke(subject,args);
        System.out.println("后处理");
        return obj;
    }
}
