package com.sky.demo.thread.thread_demo.test;


public class ThreadTest3 extends Thread {

    private int threadNo;

    public ThreadTest3(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        fun(threadNo);
    }

    public static synchronized void fun(int threadNo){
        for (int i = 0; i < 100; i++) {
            System.out.println("No." + threadNo + " : " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new ThreadTest3(i).start();
            Thread.sleep(1L);
        }
    }
}
