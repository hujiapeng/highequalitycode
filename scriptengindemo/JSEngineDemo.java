package hqcode.scriptengindemo;

import org.junit.Test;

import javax.script.*;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by JiaPeng on 2018/6/11.
 */
public class JSEngineDemo {

    public static void main(String[] args) throws Exception{
        //获得JavaScript执行引擎
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量
        Bindings bindings=engine.createBindings();
        bindings.put("factor",1);
        //绑定上下文，作用域是当前引擎范围
        engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            int first=input.nextInt();
            int second=input.nextInt();
            System.out.println("输入的参数是："+first+","+second);
            //执行js代码
            engine.eval(new FileReader("F:\\IDEAWeb\\MavenSpringMVC\\src\\test\\java\\hqcode\\scriptengindemo\\jsdemo.js"));
            //是否可调用方法
            if(engine instanceof Invocable){
                Invocable in= (Invocable) engine;
                //执行JS函数
                Double result= (Double) in.invokeFunction("formula",first,second);
                System.out.println("运算结果："+result.intValue());
            }
        }
    }

}
