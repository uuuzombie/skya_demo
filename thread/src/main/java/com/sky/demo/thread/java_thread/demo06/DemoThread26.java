package com.sky.demo.thread.java_thread.demo06;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread26 extends Thread {

    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {

        System.out.println("enter run()");
        while (isRunning) {

        }
        System.out.println("thread is stopped");
    }
}
