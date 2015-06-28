package com.sky.demo.thread.thread_demo.dead_lock;

/**
 * Created by rg on 2014/9/14.
 */
public class B {

    synchronized void bar(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name + "entered B.bar()");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + ":trying to call A.last()");
        a.last();
    }

    synchronized void last(){
        System.out.println("Inside B.last()");
    }

}
