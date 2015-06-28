package com.sky.demo.thread.semaphore.prod_cons;

/**
 * Created by rg on 2014/9/14.
 */
public class Consumer implements Runnable{

    SemQueue semQueue;

    public Consumer(SemQueue semQueue) {
        this.semQueue = semQueue;
        new Thread(this,"Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            semQueue.get();
        }
    }
}
