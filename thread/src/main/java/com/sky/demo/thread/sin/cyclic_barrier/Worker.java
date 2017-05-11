package com.sky.demo.thread.sin.cyclic_barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 15/6/28.
 */
public class Worker implements Runnable{

    String name;
    CyclicBarrier cb;

    public Worker(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;

        new Thread(this,name).start();
    }

    @Override
    public void run() {
        System.out.println(name + " start");

        try {
            int time = new Random().nextInt(10);
            System.out.println(name + " cost " + time+" s");
            TimeUnit.SECONDS.sleep(time);

            cb.await();         //等待其他线程到达障碍点
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " over");
    }
}
