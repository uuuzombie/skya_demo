package com.sky.demo.thread.java_thread.demo02;


/**
 * Created by user on 17/1/7.
 */
public class DemoThread02 extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep((int)Math.random() * 1000);
                System.out.println("run : " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
