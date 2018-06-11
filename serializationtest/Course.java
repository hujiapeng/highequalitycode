package hqcode.serializationtest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by JiaPeng on 2018/6/11.
 */
public class Course implements Serializable{

    private String name;
    private transient Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeInt(80);
    }

    private void readObject(ObjectInputStream in) throws Exception{
        in.defaultReadObject();
        this.score=in.readInt();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
