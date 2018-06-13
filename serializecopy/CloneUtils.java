package hqcode.serializecopy;

import java.io.*;

/**
 * Created by JiaPeng on 2018/6/13.
 */
public class CloneUtils {

    public static <T extends Serializable> T clone(T obj){
        T cloneObj=null;
        try {
            //读取对象字节流
            ByteArrayOutputStream byteOutputStream=new ByteArrayOutputStream();
            ObjectOutputStream objOutputStream=new ObjectOutputStream(byteOutputStream);
            objOutputStream.writeObject(obj);
            objOutputStream.close();
            //分配内存空间，写入原始对象，生成新对象
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(byteOutputStream.toByteArray());
            ObjectInputStream objInputStream=new ObjectInputStream(byteInputStream);
            //返回新对象，并做对象转换
            cloneObj= (T) objInputStream.readObject();
            objInputStream.close();
        }catch (Exception ex){

        }
        return cloneObj;
    }

}
