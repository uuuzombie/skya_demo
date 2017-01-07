package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread36 extends Thread {

    @Override
    public void run() {

        try {
            int time = (int)(Math.random() * 1000);
            System.out.println("sleep time: " + time);
            Thread.sleep(time);

            System.out.println("execute success, thread name=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
