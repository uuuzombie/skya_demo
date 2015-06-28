package com.sky.demo.thread.count_down_latch.other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 15/6/28.
 */
public class SoldierTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        final CountDownLatch cdOrder = new CountDownLatch(1);   //指挥官的命令，设置为1，指挥官一下达命令，则cutDown,变为0，战士们执行任务
        final CountDownLatch cdAnswer = new CountDownLatch(3);  //因为有三个战士，所以初始值为3，每一个战士执行任务完毕则cutDown一次，当三个都执行完毕，变为0，则指挥官停止等待。

        for (int i = 0; i < 3; i++) {
            final Runnable soldier = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread " + Thread.currentThread().getName() + " 正准备接受命令");
                        cdOrder.await();    //战士们都处于等待命令状态

                        System.out.println("Thread " + Thread.currentThread().getName() + " 已接受命令");
                        Thread.sleep((long) (Math.random() * 1000));

                        System.out.println("Thread " + Thread.currentThread().getName() + " 回应命令处理结果");
                        cdAnswer.countDown();   //任务执行完毕，返回给指挥官，cdAnswer减1。

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(soldier);   //为线程池添加任务
        }


        /*
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Thread " + Thread.currentThread().getName() + " 即将发布命令");

            cdOrder.countDown();    //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
            System.out.println("Thread " + Thread.currentThread().getName() + " 已发送命令，正在等待结果");

            cdAnswer.await();   //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
            System.out.println("Thread " + Thread.currentThread().getName() + " 已收到所有响应结果");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        */

        final Runnable commander = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Thread " + Thread.currentThread().getName() + " 即将发布命令");

                    cdOrder.countDown();    //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
                    System.out.println("Thread " + Thread.currentThread().getName() + " 已发送命令，正在等待结果");

                    cdAnswer.await();   //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
                    System.out.println("Thread " + Thread.currentThread().getName() + " 已收到所有响应结果");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        service.execute(commander);

        //任务结束，停止线程池的所有线程
        service.shutdown();
    }
}
