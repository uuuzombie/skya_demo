package com.sky.demo.thread.java_thread.demo04;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread13_01 extends Thread {

    private App13 app;

    public DemoThread13_01(App13 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.add("A");
    }
}
