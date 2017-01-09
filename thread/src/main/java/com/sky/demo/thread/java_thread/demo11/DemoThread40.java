package com.sky.demo.thread.java_thread.demo11;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread40 extends Thread {

    private App40 app ;

    public DemoThread40(App40 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.conditionAwait();
    }
}
