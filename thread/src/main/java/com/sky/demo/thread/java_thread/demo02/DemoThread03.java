package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread03 extends Thread {

    @Override
    public void run() {
        System.out.println("run : " + Thread.currentThread().getName());
    }
}
