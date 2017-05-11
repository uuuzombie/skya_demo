package com.sky.demo.thread.sin.count_down_latch.other;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 15/6/28.
 */
public class BookTest {
    public static void main(String[] args) {

        int bookListSize = 2;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));

        final CountDownLatch countDownLatch = new CountDownLatch(bookListSize);
        for (int i = 0;i < bookListSize; i++) {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread " + Thread.currentThread().getName() + " is running");

                        long sleepTime = (long) (new Random().nextInt(10) * 1000);
                        System.out.println("Thread " + Thread.currentThread().getName() + " sleep time :" + sleepTime);
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }

        boolean await = false;
        try {
            await = countDownLatch.await(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (await ){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        executor.shutdown();
    }
}
