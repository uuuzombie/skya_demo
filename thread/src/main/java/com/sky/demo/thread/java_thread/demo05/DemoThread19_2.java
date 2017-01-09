package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread19_2 extends Thread {

    private App19 app;

    public DemoThread19_2(App19 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.syncBlockMethodB();
    }
}
