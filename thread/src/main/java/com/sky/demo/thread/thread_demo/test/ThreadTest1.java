package com.sky.demo.thread.thread_demo.test;


public class ThreadTest1 extends Thread {

    private int threadNo;

    public ThreadTest1(int threadNo) {
        this.threadNo = threadNo;
    }

    //一共十个线程，每个线程持有自己线程对象的那个对象锁。这必然不能产生同步的效果
    @Override
    public synchronized void run() {
        for (int i = 0;i < 100;++i){
            System.out.println("No." + threadNo + " : " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i= 0;i < 10; ++i){
            new ThreadTest1(i).start();
            Thread.sleep(1L);
        }
    }
}
