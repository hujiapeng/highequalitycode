package hqcode.serializationtest;

import java.io.*;

/**
 * Created by JiaPeng on 2018/6/8.
 */
public class SerializationUtils {

    private static String FILE_NAME = SerializationUtils.class.getResource("/").getPath().concat("person");

    public static void writeObject(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readObject(){
        Object obj=null;
        try {
            ObjectInput objectInput=new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj=objectInput.readObject();
            objectInput.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

}
