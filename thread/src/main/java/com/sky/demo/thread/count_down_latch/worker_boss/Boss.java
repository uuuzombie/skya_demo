package com.sky.demo.thread.count_down_latch.worker_boss;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 15/6/28.
 */
public class Boss implements Runnable {

    private CountDownLatch countDownLatch;  //同步计数器

    public Boss(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("老板正在等所有的工人干完活....");

        try {
            //this.countDownLatch.await();
            //设置等待时间
            boolean await = this.countDownLatch.await(5, TimeUnit.SECONDS);
            System.out.println("\n时间到\n");
//            if (await) {
//                System.out.println("所有人干完了");
//            } else {
//                System.out.println("时间到，有人未干完");
//            }

            if (!await){
                System.out.println("超时");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("老板开始检查了！");

    }
}
