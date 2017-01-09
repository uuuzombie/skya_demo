package com.sky.demo.thread.java_thread.demo06;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 17/1/9.
 */
public class App29 {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    // atomicInteger.addAndGet(100) ，atomicInteger.getAndAdd(1) 这两个操作是可分割导致的
    public void add() { //synchronized
        System.out.println("Thread name " + Thread.currentThread().getName() + ", result = " + atomicInteger.addAndGet(100));

        atomicInteger.getAndAdd(1);
    }
}
