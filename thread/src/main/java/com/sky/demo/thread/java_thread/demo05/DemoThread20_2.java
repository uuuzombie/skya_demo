package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread20_2 extends Thread {

    private App20 app ;

    public DemoThread20_2(App20 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.setValue("B", "BB");
    }
}
