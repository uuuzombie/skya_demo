package com.sky.demo.thread.art_of_java_con.chapter4;

/**
 * Created by user on 17/3/22.
 */
public class ThreadState {


    //该线程不断的睡眠
    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //该线程在Waiting.class 实例上等待
    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //该线程在Blocked.class 实例加锁后，不会释放该锁
    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();

        //两个Blocked线程，一个获得锁，另一个被阻塞
        new Thread(new Blocked(), "BlockThread-1").start();
        new Thread(new Blocked(), "BlockThread-2").start();
    }

}
