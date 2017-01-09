package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class App19 {

    public void syncBlockMethodA() {

        synchronized (this) {
            try {
                System.out.println("A start time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncBlockMethodB() {
        synchronized (this) {
            System.out.println("B time = " + System.currentTimeMillis());
        }
    }
}
