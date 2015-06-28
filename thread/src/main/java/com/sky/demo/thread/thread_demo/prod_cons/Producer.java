package com.sky.demo.thread.thread_demo.prod_cons;


public class Producer implements Runnable{
    ThreadQueue threadQueue;

    public Producer(ThreadQueue threadQueue) {
        this.threadQueue = threadQueue;
        new Thread(this,"Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            threadQueue.put(i++);
        }
    }
}
