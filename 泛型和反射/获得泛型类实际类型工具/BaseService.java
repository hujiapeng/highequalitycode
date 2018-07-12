package hqcode.泛型和反射.获得泛型类实际类型工具;

public abstract class BaseService<T,D> {

    public D getDao() throws IllegalAccessException, InstantiationException {
        return (D) Utils.getGenericClassType(getClass(),1).newInstance();
    }

}
