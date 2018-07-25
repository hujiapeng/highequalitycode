package com.hjp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 号令枪
 */
public class CountDownLatchDemo {

    static class Runner implements Callable<Integer>{

        //开始信号
        private CountDownLatch begin;
        //结束信号
        private CountDownLatch end;

        public Runner(CountDownLatch _begin,CountDownLatch _end){
            begin=_begin;
            end=_end;
        }

        @Override
        public Integer call() throws Exception {
            //跑步成绩
            int score=new Random().nextInt(25);
            //等待发令枪
            begin.await();
            //跑步中······
            TimeUnit.MILLISECONDS.sleep(score);
            //跑步者跑完全程
            end.countDown();
            return score;
        }
    }

    public static void main(String[] args) throws Exception {
        //参加赛跑人数
        int num=1;
        //发令枪只响一次
        CountDownLatch begin=new CountDownLatch(1);
        //参与跑步有多个
        CountDownLatch end=new CountDownLatch(num);
        //每个跑步者一个跑道
        ExecutorService executorService=Executors.newFixedThreadPool(num);
        //记录比赛成绩
        List<Future<Integer>> list=new ArrayList<>();
        //跑步者就位，所有线程处于等待状态
        for (int i = 0; i < num; i++) {
            list.add(executorService.submit(new Runner(begin,end)));
        }
        //发令枪响，跑步者开始跑步
        begin.countDown();
        //等待所有跑步者跑完
        end.await();
        int count=0;
        //统计总分
        for(Future<Integer> future:list){
            count+=future.get();
        }
        System.out.println("平均分数："+count/num);
        //如果不使用下面代码，线程一直处于等待状态（线程池中的线程处于）
        executorService.shutdown();
    }

}
