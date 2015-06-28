package com.sky.demo.thread.semaphore.opt_thread;

import java.util.concurrent.Semaphore;

public class IncThread implements Runnable{

    String name;
    Semaphore sem;

    public IncThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            sem.acquire();          //获取信号量
            System.out.println(name + " gets a permit");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ":" + Shared.count);
                Thread.sleep(10L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " release the permit");
        sem.release();
    }
}
