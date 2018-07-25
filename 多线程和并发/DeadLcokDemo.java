package com.hjp;

public class DeadLcokDemo {

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

        public synchronized void b2(){
            System.out.println("进入B.b2()");
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
