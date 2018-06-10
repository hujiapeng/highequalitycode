package hqcode.threelementexp;

import org.junit.Test;

/**
 * Created by JiaPeng on 2018/6/11.
 */
public class TestDemo {

    @Test
    public void func(){
        int i=80;
        String str=String.valueOf(i<90?90:100.0);
        if("90".equals(str)){
            System.out.println("```````````````````");
        }
        System.out.println(str);
    }

}
