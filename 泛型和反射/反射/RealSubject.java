package hqcode.泛型和反射.反射;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("业务处理");
    }
}
