package com.hjp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 自旋锁
 */
public class TryLockDemo {

    static class A{
        public synchronized void a1(B b){
            String name=Thread.currentThread().getName();
            System.out.println(name+"进入A.a1()");
            try {
                Thread.sleep(1000);
            }catch (Exception ex){

            }
            System.out.println(name+"试图访问B.b2()");
            b.b2();
        }

        public synchronized void a2(){
            System.out.println("进入A.a2()");
        }
    }

    static class B{

        Lock lock=new ReentrantLock();

        public synchronized void b1(A a){
            String name =Thread.currentThread().getName();
            System.out.println(name+"进入B.b1()");
            try {
                Thread.sleep(1000);
            }catch (Exception ex){

            }
            System.out.println(name+"试图访问A.a2()");
            a.a2();
        }

        public void b2(){
            try {
                if(lock.tryLock(20,TimeUnit.SECONDS)){
                    System.out.println("进入B.b2()");
                }
            }catch (Exception ex){

            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String args[]){
        final A a=new A();
        final B b=new B();
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.a1(b);
            }
        },"线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                b.b1(a);
            }
        },"线程B").start();
    }

}
