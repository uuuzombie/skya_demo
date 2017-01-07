package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread05 extends Thread {

    static {
        System.out.println("静态块 Thread.currentThread().getName() : " + Thread.currentThread().getName());
//        System.out.println("静态块 Thread name : " + this.getName());

    }

    public DemoThread05() {

        System.out.println("构造方法 Thread.currentThread().getName() : " + Thread.currentThread().getName());
        System.out.println("构造方法 this.getName() : " + this.getName());

    }

    @Override
    public void run() {
        System.out.println("run()方法 Thread.currentThread().getName() : " + Thread.currentThread().getName());
        System.out.println("run()方法 this.getName() : " + this.getName());
    }
}
