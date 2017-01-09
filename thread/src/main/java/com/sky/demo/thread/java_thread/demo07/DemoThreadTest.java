package com.sky.demo.thread.java_thread.demo07;

/**
 * Created by user on 17/1/9.
 */
public class DemoThreadTest {

    //当一组Java线程发生死锁时，这两个线程就永远不能再使用了，
    //并且由于两个线程分别持有了两个锁，那么这两段同步代码/代码块也无法再运行了----除非终止并重启应用
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        DemoThread_1 thread_1 = new DemoThread_1(deadLock);
        DemoThread_2 thread_2 = new DemoThread_2(deadLock);

        thread_1.start();
        thread_2.start();
    }
}
