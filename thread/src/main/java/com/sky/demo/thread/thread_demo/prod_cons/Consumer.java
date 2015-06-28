package com.sky.demo.thread.thread_demo.prod_cons;


public class Consumer implements Runnable{

    ThreadQueue threadQueue;

    public Consumer(ThreadQueue threadQueue) {
        this.threadQueue = threadQueue;
        new Thread(this,"Consumer").start();

    }

    @Override
    public void run() {
        while(true){
            threadQueue.get();
        }
    }
}
