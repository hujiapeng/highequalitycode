package com.hjp.callabledemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestDemo {

    public static void main(String args[]) throws Exception {
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(new TaxCalculator(100));
        while (!future.isDone()){
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("#");
        }
        System.out.println("计算完成，税金是："+future.get()+"元");
        executorService.shutdown();
    }

}
