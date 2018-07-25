package com.hjp;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {

    @Test
    public void f1() throws InterruptedException {
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        //插入元素，如果已满返回false
        queue.offer(2);
        //从队列头部取出一个元素
        queue.take();
        //插入元素，如果有空余位置
        queue.put(4);
    }

}
