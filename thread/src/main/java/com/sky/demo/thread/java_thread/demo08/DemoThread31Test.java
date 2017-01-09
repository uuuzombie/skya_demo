package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread31Test {

    //wait()释放锁
    //如果wait()方法不释放锁，那么Thread-1根本不会进入同步代码块打印的
    public static void main(String[] args) {
        Object lock = new Object();
        DemoThread31 demoThread1 = new DemoThread31(lock);
        DemoThread31 demoThread2 = new DemoThread31(lock);
        demoThread1.start();
        demoThread2.start();
    }
}
