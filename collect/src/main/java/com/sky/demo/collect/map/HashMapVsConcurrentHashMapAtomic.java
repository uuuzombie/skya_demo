package com.sky.demo.collect.map;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 17/5/12.
 */
public class HashMapVsConcurrentHashMapAtomic {

    private static final int THREAD_POOL_SIZE = 1000;
    private static final String key = "key";

    private static final Map<String, AtomicInteger> hashMap = Maps.newHashMap();
    private static final Map<String, AtomicInteger> concurrentHashMap = Maps.newConcurrentMap();


    public void add(Map<String, AtomicInteger> map, String key) {
        AtomicInteger value = map.get(key);
        if (value == null) {
            map.put(key, new AtomicInteger(1));
        } else {
            map.get(key).getAndIncrement();
        }
    }

    public void addByPutIfAbsent(Map<String, AtomicInteger> map, String key) {
        AtomicInteger value = map.get(key);
        if (value == null) {
            map.putIfAbsent(key, new AtomicInteger(1));
        } else {
            map.get(key).getAndIncrement();
        }
    }

    public synchronized void syncAdd(Map<String, AtomicInteger> map, String key) {
        AtomicInteger value = map.get(key);
        if (value == null) {
            map.put(key, new AtomicInteger(1));
        } else {
            map.get(key).getAndIncrement();
        }
    }


    public void performTest(Map<String, AtomicInteger> map) throws InterruptedException {
        System.out.println("Test for " + map.getClass());

        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {

            executorService.execute(() -> {

                for (int j = 0; j < 1000; j++) {
                    if (map instanceof HashMap) {
//                        add(map, key);  //不安全
//                        addByPutIfAbsent(map, key);   //不安全

                        syncAdd(map, key);      //安全

                    } else if (map instanceof ConcurrentHashMap) {
//                        add(map, key);  //不安全
//                        addByPutIfAbsent(map, key);   //不安全

                        syncAdd(map, key);      //安全
                    }
                }
            });
        }


        executorService.shutdown();

        //阻塞，一直到线程池内任务完成
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);


        long end = System.currentTimeMillis();
        System.out.println("take time:" + (end - start) + " ms");
        System.out.println(map);

    }


    public static void main(String[] args) throws InterruptedException {

        new HashMapVsConcurrentHashMapAtomic().performTest(hashMap);
        new HashMapVsConcurrentHashMapAtomic().performTest(concurrentHashMap);
    }

}
