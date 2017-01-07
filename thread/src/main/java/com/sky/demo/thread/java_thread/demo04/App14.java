package com.sky.demo.thread.java_thread.demo04;

/**
 * Created by user on 17/1/7.
 */
public class App14 {


    public synchronized void syncMethod() {
        try {
            System.out.println("Begin syncMethod, threadName = " + Thread.currentThread().getName());
            long start = System.currentTimeMillis();
            Thread.sleep(5000);
            long end = System.currentTimeMillis();
            System.out.println("End syncMethod, threadName = " + Thread.currentThread().getName()
                    + ", cost Time = " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void nonSyncMethod() {
        try {
            System.out.println("Begin nonSyncMethod, threadName = " + Thread.currentThread().getName());
            long start = System.currentTimeMillis();
            Thread.sleep(3000);
            long end = System.currentTimeMillis();
            System.out.println("End nonSyncMethod, threadName = " + Thread.currentThread().getName()
                    + ", cost Time = " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
