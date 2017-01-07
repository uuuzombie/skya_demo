package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread08 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10 ; i++) {
            long start = System.currentTimeMillis();
            Thread.yield();
            long end = System.currentTimeMillis();

            System.out.println("cost time : " + (end - start));
        }
    }
}
