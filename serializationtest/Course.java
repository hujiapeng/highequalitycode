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

    //out.writeXX或者in.readXX是按照类似队列方式先进先出，写入或读入值
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();//告知JVM按照默认规则写入对象
        out.writeInt(80);
    }

    private void readObject(ObjectInputStream in) throws Exception{
        in.defaultReadObject();//告知JVM按照默认规则读入对象
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
