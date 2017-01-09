package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread34Test {

    //notifyAll()唤醒所有线程
    public static void main(String[] args) {
        try {
            Object lock = new Object();

            DemoThread34_1 demoThread34_01 = new DemoThread34_1(lock);
            DemoThread34_1 demoThread34_02 = new DemoThread34_1(lock);
            DemoThread34_1 demoThread34_03 = new DemoThread34_1(lock);
            demoThread34_01.start();
            demoThread34_02.start();
            demoThread34_03.start();

            Thread.sleep(2000);

            DemoThread34_2 demoThread34_2 = new DemoThread34_2(lock);
            demoThread34_2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
