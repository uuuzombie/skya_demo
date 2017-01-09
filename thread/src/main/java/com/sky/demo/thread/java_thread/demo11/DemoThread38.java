package com.sky.demo.thread.java_thread.demo11;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread38 extends Thread {

    private App38 app ;

    public DemoThread38(App38 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.testReentrantLockMethod();
    }
}
