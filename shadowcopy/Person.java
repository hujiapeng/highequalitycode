package hqcode.shadowcopy;

/**
 * Created by JiaPeng on 2018/6/11.
 */
public class Person implements Cloneable{

    private String name;
    private Person parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String _name){
        this.name=_name;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public Person(String _name, Person _parent){
        this.name=_name;
        this.parent=_parent;
    }

    //如果只需要浅拷贝就注释掉下面clone方法
    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person=(Person)super.clone();
        person.setParent(new Person(person.getParent().getName()));
        return person;
    }
}
