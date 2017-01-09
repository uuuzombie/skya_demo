package com.sky.demo.thread.java_thread.demo06;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread29 extends Thread {

    private App29 app;

    public DemoThread29(App29 app) {
        this.app = app;
    }

    @Override
    public void run() {
        app.add();
    }
}
