package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class App18 {


    public void doSomeTask() {

        //non sync
        for (int i = 0; i < 100; i++) {
            System.out.println("non sync method, i = " + i + ", thread name : " + Thread.currentThread().getName());
        }

        //sync
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("sync method, i = " + i + ", thread name : " + Thread.currentThread().getName());
            }
        }

    }
}
