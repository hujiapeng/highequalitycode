package hqcode.泛型和反射.获得泛型类实际类型工具;

public class TestDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        UserService userService=new UserService();
        userService.getDataById();
    }

}
