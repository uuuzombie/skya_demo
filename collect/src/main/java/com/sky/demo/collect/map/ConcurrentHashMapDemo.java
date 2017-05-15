package com.sky.demo.collect.map;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 17/5/12.
 */
public class ConcurrentHashMapDemo {

    private static final Map<String, AtomicInteger> map = new ConcurrentHashMap<String, AtomicInteger>();

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public void getAndIncrement(String key) {
        if (map.get(key) == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(key, new AtomicInteger());   //put方法跟普通的HashMap没什么区别，如果key相同，会覆盖。
        }

        map.get(key).incrementAndGet();
    }


    public void getAndIncrementByPutIfAbsent(String key) {
        if (map.get(key) == null) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            map.putIfAbsent(key, new AtomicInteger());
        }

        map.get(key).incrementAndGet();
    }


    public static void main(String[] args) throws InterruptedException {

        String key1 = "key1";
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                new ConcurrentHashMapDemo().getAndIncrement(key1);
            });

            thread.start();
        }

        Thread.sleep(2000);
        System.out.println(map.get(key1).get());


        String key2 = "key2";
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                new ConcurrentHashMapDemo().getAndIncrementByPutIfAbsent(key2);
            });

            thread.start();
        }

        Thread.sleep(2000);
        System.out.println(map.get(key2).get());

    }
}

