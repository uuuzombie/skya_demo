package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread30_2 extends Thread {

    private Object lock;

    public DemoThread30_2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            try {
                System.out.println("begin notify time :" + System.currentTimeMillis());
                lock.notify();
                System.out.println("end notify time :" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
