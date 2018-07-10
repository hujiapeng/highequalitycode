package hqcode.泛型和反射.反射装饰者模式;

/**
 * 《猫和老鼠》之Jerry
 */
public class Rat implements Animal {
    @Override
    public void doStuff() {
        System.out.println("Jerry will play with Tom.");
    }
}
