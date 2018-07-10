package hqcode.泛型和反射.反射装饰者模式;

public class ProxyDemo {

    public static void main(String[] args){
        Animal jerry=new Rat();
        //增加飞行能力
        jerry=new DecorateAnimal(jerry,FlyFeature.class);
        //增加钻地能力
        jerry=new DecorateAnimal(jerry,DigFeature.class);
        jerry.doStuff();
    }

}
