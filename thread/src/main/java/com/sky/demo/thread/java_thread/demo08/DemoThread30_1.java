package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread30_1 extends Thread {

    private Object lock;

    public DemoThread30_1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            try {
                System.out.println("begin wait time :" + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait time :" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
