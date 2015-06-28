package com.sky.demo.thread.semaphore.prod_cons;

/**
 * Created by rg on 2014/9/14.
 */
public class Producer implements Runnable{

    SemQueue semQueue;

    public Producer(SemQueue semQueue) {
        this.semQueue = semQueue;
        new Thread(this,"Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            semQueue.put(i);
        }
    }
}
