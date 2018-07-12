package hqcode.泛型和反射.反射模板模式;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 数据库初始化模板
 */
public abstract class AbsPopulator {

    //模板方法
    public final void dataInitialing() throws InvocationTargetException, IllegalAccessException {
        //获得所有public方法
        Method[] methods = getClass().getMethods();
        for (Method method : methods) {
            //判断是否是初始化方法
            if(isInitDataMethod(method)){
                method.invoke(this);
            }
        }
    }

    protected boolean isInitDataMethod(Method method){
        return method.getName().startsWith("init")&&Modifier.isPublic(method.getModifiers())&&
                method.getReturnType().equals(Void.TYPE)&&!method.isVarArgs()&&!Modifier.isAbstract(method.getModifiers());
    }

}
