package com.sky.demo.thread.thread_demo.dead_lock;

/**
 * Created by rg on 2014/9/14.
 * 死锁的例子
 */
public class DeadLock implements Runnable{

    A a = new A();
    B b = new B();

    public DeadLock() {
        Thread.currentThread().setName("MainThread");

        Thread t = new Thread(this,"RacingThread");     //第二个线程，设置死锁环境
        t.start();

        a.foo(b);       //主线程访问
        System.out.println("Back in MainThread");

    }

    @Override
    public void run() {
        b.bar(a);           //其他线程访问
        System.out.println("Back in other thread");
    }
}
