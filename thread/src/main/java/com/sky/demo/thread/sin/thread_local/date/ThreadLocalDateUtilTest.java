package com.sky.demo.thread.sin.thread_local.date;

import java.util.Date;

/**
 * Created by rg on 2015/9/19.
 */
public class ThreadLocalDateUtilTest {

    public static void main(String[] args) {

        int count = 100;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; ++i) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Date now = new Date();
                    String dateStr = ThreadLocalDateUtil.formatDate(now);
                    System.out.println(Thread.currentThread().getName() + ":" + dateStr);
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }

}
