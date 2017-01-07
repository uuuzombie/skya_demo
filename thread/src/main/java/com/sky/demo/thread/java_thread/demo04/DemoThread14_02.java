package com.sky.demo.thread.java_thread.demo04;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread14_02 extends Thread {

    private App14 app;

    public DemoThread14_02(App14 app) {
        this.app = app;
    }

    @Override
    public void run() {

        app.nonSyncMethod();
    }
}
