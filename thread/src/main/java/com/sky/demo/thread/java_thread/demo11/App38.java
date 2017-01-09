package com.sky.demo.thread.java_thread.demo11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 17/1/9.
 */
public class App38 {

    private Lock lock = new ReentrantLock();

    public void testReentrantLockMethod() {

        try {
            lock.lock();

            for (int i = 0;i < 10 ;i ++) {
                System.out.println("Thread name=" + Thread.currentThread().getName() + ", i = " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
