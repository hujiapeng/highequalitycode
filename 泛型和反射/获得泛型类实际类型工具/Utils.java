package hqcode.泛型和反射.获得泛型类实际类型工具;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Utils {

    //获得一个泛型类的实际类型
    public static <T> Class<T> getGenericClassType(Class cls, int index) {
        Type type = cls.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types.length > 0 && index < types.length) {
                Type curType = types[index];
                if (curType instanceof Class) {
                    return (Class<T>) curType;
                }
            }
        }
        return (Class<T>) Object.class;
    }

}
