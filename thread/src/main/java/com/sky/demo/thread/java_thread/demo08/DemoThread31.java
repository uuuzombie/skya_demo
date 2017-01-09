package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread31 extends Thread {

    private Object lock;

    public DemoThread31(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        App31 app = new App31();
        app.method(lock);
    }
}
