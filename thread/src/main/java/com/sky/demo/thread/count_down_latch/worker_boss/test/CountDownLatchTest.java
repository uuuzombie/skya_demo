package com.sky.demo.thread.count_down_latch.worker_boss.test;

import com.sky.demo.thread.count_down_latch.worker_boss.Boss;
import com.sky.demo.thread.count_down_latch.worker_boss.Worker;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rg on 15/6/28.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(); //创建一个线程池

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Worker worker1 = new Worker(countDownLatch,"work1");
        Worker worker2 = new Worker(countDownLatch,"work2");
        Worker worker3 = new Worker(countDownLatch,"work3");
        Boss boss = new Boss(countDownLatch);

        //为线程池添加任务
        executor.execute(worker1);
        executor.execute(worker2);
        executor.execute(worker3);
        executor.execute(boss);

        //任务结束，停止线程池的所有线程
        executor.shutdown();
    }
}
