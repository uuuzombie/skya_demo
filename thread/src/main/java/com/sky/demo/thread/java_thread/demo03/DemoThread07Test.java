package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread07Test {

    //sleep() 作用是在指定的毫秒内让当前"正在执行的线程"休眠（暂停执行）。该线程不丢失任何监视器的所属权
    public static void main(String[] args) {

        DemoThread07 thread07 = new DemoThread07();
        System.out.println("Thread name : " + Thread.currentThread().getName() + " begin");
        thread07.start();
        System.out.println("Thread name : " + Thread.currentThread().getName() + " end");

    }
}
