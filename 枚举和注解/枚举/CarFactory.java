package hqcode.枚举和注解.枚举;

public enum CarFactory {

    //定义工厂能生产的汽车类型
    FordCar {
        @Override
        public Car create() {
            return new FordCar();
        }
    }, BuickCar {
        @Override
        public Car create() {
            return new BuickCar();
        }
    };

//    FordCar,BuickCar;
//
//    //生产汽车
//    public Car create() {
//        switch (this) {
//            case FordCar:
//                return new FordCar();
//            case BuickCar:
//                return new BuickCar();
//            default:
//                throw new AssertionError("无效参数");
//        }
//    }

    public abstract Car create();

}


interface Car {

}

class FordCar implements Car {

}

class BuickCar implements Car {

}

//普通工厂类实现
class NorMalCarFactory {

    public static Car createCar(Class<? extends Car> cls) {
        try {
            return cls.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}