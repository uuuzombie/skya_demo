package com.sky.demo.thread.java_thread.demo06;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread25_1 extends Thread {


    @Override
    public void run() {
        App25.syncStaticMethodA();
    }
}
