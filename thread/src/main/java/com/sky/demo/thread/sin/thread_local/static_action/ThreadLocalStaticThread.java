package com.sky.demo.thread.sin.thread_local.static_action;

/**
 * Created by rg on 2015/10/4.
 */
public class ThreadLocalStaticThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalStaticAction.increase();

        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalStaticAction.getValue());
    }

    public static void main(String[] args) {
        int count = 1000;
        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; ++i) {
            threads[i] = new Thread(new ThreadLocalStaticThread());
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ThreadLocalStaticAction.getValue());
    }
}
