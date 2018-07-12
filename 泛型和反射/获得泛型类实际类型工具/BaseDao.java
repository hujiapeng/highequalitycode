package hqcode.泛型和反射.获得泛型类实际类型工具;

import java.lang.reflect.Field;

public abstract class BaseDao<T> {
    //获得T的运行期类型
    private Class<T> cls=Utils.getGenericClassType(getClass(),0);

    public void getDataById(Long id){
        System.out.println("获得数据对应的对象类型为："+cls);
        Field[] fields=cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("字段"+fields[i].getName());
        }
    }
}
