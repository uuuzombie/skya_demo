package com.sky.demo.thread.java_thread.demo07;

/**
 * Created by user on 17/1/9.
 */
public class DeadLock {

    private final Object lockA = new Object();
    private final Object lockB = new Object();


    public void methodA() throws Exception{
        synchronized (lockA) {
            Thread.sleep(2000);
            synchronized (lockB) {
                System.out.println("end method A");
            }
        }
    }

    public void methodB() throws Exception{
        synchronized (lockB) {
            Thread.sleep(1000);
            synchronized (lockA) {
                System.out.println("end method B");
            }
        }
    }
}
