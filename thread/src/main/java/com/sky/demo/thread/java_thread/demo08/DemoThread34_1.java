package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread34_1 extends Thread {

    private Object lock;

    public DemoThread34_1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        App34 app = new App34();
        app.waitMethod(lock);
    }
}
