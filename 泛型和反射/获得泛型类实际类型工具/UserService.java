package hqcode.泛型和反射.获得泛型类实际类型工具;

public class UserService extends BaseService<UserEntity,UserDao> {

    public void getDataById() throws InstantiationException, IllegalAccessException {
        getDao().getDataById(1L);
    }

}
