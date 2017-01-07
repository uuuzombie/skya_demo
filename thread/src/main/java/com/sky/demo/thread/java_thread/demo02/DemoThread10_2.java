package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread10_2 extends Thread {

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {

        }
        long end = System.currentTimeMillis();

        System.out.println("--- use time : " + (end - start));
    }
}
