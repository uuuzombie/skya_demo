package com.sky.demo.thread.sin.count_down_latch.worker_boss;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 15/6/28.
 */
public class Worker implements Runnable{

    private CountDownLatch countDownLatch;      //同步计数器
    private String name;

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.doWork();

        try {
            Random random = new Random();
            int count = random.nextInt(10);
            System.out.println(this.name + " 需要 " + count + " s");
            TimeUnit.SECONDS.sleep(count);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(this.name + " 活干完了!");
            countDownLatch.countDown();
        }
    }

    private void doWork() {
        System.out.println(this.name + " 正在干活!!");
    }
}
