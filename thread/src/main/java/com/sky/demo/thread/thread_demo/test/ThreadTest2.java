package com.sky.demo.thread.thread_demo.test;


public class ThreadTest2 extends Thread {

    private int threadNo;
    private String lock;

    public ThreadTest2(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }

    @Override
    public void run() {
        //同步块的对象锁，就是 main方法中创建的那个String对象
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                System.out.println("No." + threadNo + " : " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";

        for (int i = 0; i < 10; i++) {
            new ThreadTest2(i,lock).start();
            Thread.sleep(1L);
        }

    }
}
