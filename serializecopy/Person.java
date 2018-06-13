package hqcode.serializecopy;

import java.io.Serializable;

/**
 * Created by JiaPeng on 2018/6/11.
 */
public class Person implements Serializable{

    private static final long serialVersionUID = 42L;

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



}
