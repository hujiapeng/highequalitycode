package hqcode.枚举和注解.注解;

@Desc(c = Desc.Color.White)
public abstract class Bird {

    public abstract Desc.Color getColor();
}

class Sparrow extends Bird{

    private Desc.Color color;

    public Sparrow(){
        color=Desc.Color.Grayish;
    }

    public Sparrow(Desc.Color _color){
        color=_color;
    }

    @Override
    public Desc.Color getColor() {
        return color;
    }
}

enum BirdNest{
    Sparrow;

    public Bird reproduce(){
        Desc desc= hqcode.枚举和注解.注解.Sparrow.class.getAnnotation(Desc.class);
        return desc==null?new Sparrow():new Sparrow(desc.c());
    }
}


