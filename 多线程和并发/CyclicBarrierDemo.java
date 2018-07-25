package com.hjp;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    static class Worker implements Runnable {
        //关卡
        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier _cyclicBarrier) {
            cyclicBarrier = _cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "-到达汇合点");
                //到达汇合点
                cyclicBarrier.await();
            } catch (Exception ex) {

            }
        }
    }

    public static void main(String[] args) throws Exception {
        //设置汇集数量，以及汇集完成后的任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("隧道已经打通！");
            }
        });
        //工人1挖隧道
        new Thread(new Worker(cyclicBarrier), "工人1").start();
        //工人2挖隧道
        new Thread(new Worker(cyclicBarrier), "工人2").start();
    }

}
