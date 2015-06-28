package com.sky.demo.thread.thread_demo.dead_lock;

/**
 * Created by rg on 2014/9/14.
 */
public class A {

    synchronized void foo(B b){
        String name = Thread.currentThread().getName();
        System.out.println(name + "enter A.foo()");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + ":try to call B.last()");
        b.last();
    }


    synchronized void last(){
        System.out.println("Inside A.last()");
    }
}
