package com.sky.demo.thread.java_thread.demo07;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread_2 extends Thread {

    private DeadLock deadLock = new DeadLock();

    public DemoThread_2(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        try {
            deadLock.methodB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
