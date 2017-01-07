package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread07 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread name : " + Thread.currentThread().getName() + " begin");
            Thread.sleep(3000);
            System.out.println("Thread name : " + Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
