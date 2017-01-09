package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class App32 {

    public void waitMethod(Object lock) {

        synchronized (lock) {
            try {
                System.out.println("Thread name : " + Thread.currentThread().getName() + " begin wait()");
                lock.wait();
                System.out.println("Thread name : " + Thread.currentThread().getName() + " end wait()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void notifyMethod(Object lock) {

        synchronized (lock) {
            try {
                System.out.println("Thread name : " + Thread.currentThread().getName() + " begin notify()");
                lock.notify();
                Thread.sleep(2000);
                System.out.println("Thread name : " + Thread.currentThread().getName() + " end notify()");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
