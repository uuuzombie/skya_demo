package com.sky.demo.thread.java_thread.demo06;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread25_3 extends Thread {

    private App25 app;

    public DemoThread25_3(App25 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.syncMethodC();
    }
}
