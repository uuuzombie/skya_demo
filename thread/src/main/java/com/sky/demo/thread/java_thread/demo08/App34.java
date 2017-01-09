package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class App34 {

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

    public void notifyAllMethod(Object lock) {

        synchronized (lock) {
            try {
                System.out.println("Thread name : " + Thread.currentThread().getName() + " begin notify()");
                lock.notifyAll();
                System.out.println("Thread name : " + Thread.currentThread().getName() + " end notify()");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
