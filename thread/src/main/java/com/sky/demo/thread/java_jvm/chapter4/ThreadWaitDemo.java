package com.sky.demo.thread.java_jvm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 17/3/28.
 */
public class ThreadWaitDemo {


    /**
     * 线程死循环
     */
    public static void createBusyThread() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ;
                }
            }
        }, "testBusyThread");

        thread.start();
        System.out.println("create busy thread..");
    }


    public static void createLockThread(final Object lock) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");

        thread.start();
        System.out.println("create lock thread");
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        bufferedReader.readLine();

        createBusyThread();

//        bufferedReader.readLine();
        createLockThread(new Object());
    }

}
