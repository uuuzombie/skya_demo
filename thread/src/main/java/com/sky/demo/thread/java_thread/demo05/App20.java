package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class App20 {

    private String name;
    private String pass;

    private Object lock = new Object();  //全局对象  must init

    public void setValue(String name, String pass) {

        synchronized (lock) {

            try {
                System.out.println("Thread name = " + Thread.currentThread().getName() + ", enter sync block");
                this.name = name;
                Thread.sleep(2000);
                this.pass = pass;
                System.out.println("Thread name = " + Thread.currentThread().getName() + ", leave sync block");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
