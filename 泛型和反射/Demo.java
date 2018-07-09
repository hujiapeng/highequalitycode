package hqcode.泛型和反射;

public class Demo {

    public static void main(String[] args){
        discount(new Me());
    }

    public static <T extends Stuff&Passenger> void discount(T t){
        if(t.getSalary()<2500&&t.isStanding()){
            //工资小小于2500并且站立
        }
    }
}
