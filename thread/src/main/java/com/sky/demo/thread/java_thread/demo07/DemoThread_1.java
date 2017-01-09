package com.sky.demo.thread.java_thread.demo07;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread_1 extends Thread {

    private DeadLock deadLock;

    public DemoThread_1(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        try {
            deadLock.methodA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
