package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread32_2 extends Thread {

    private Object lock;

    public DemoThread32_2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        App32 app = new App32();
        app.notifyMethod(lock);
    }
}
