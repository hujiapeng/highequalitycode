package hqcode.泛型和反射.反射模板模式;

public class UserPopulator extends AbsPopulator {

    public void initUser(){
        System.out.println("初始化用户表，如创建、加载数据等");
    }

    public void initPassword(){
        System.out.println("初始化密码");
    }

    public void initJobs(){
        System.out.println("初始化工作任务");
    }

}
