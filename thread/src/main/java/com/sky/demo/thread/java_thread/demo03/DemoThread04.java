package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread04 extends Thread {


    static {
        System.out.println("静态块 Thread name : " + Thread.currentThread().getName());
    }

    public DemoThread04() {
        System.out.println("构造方法 Thread name : " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run()方法 Thread name : " + Thread.currentThread().getName());
    }
}
