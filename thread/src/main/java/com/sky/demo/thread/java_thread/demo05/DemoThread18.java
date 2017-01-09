package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread18 extends Thread {

    private App18 app;

    public DemoThread18(App18 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.doSomeTask();
    }
}
