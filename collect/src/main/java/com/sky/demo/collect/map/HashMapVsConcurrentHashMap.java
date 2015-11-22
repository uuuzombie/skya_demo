package com.sky.demo.collect.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Maps;

/**
 * Created by rg on 11/22/15.
 */
public class HashMapVsConcurrentHashMap {

    //ConcurrentHashMap，并发对其操作的线程数小于16时，其稳定性很好，否则会出现和非同步的HashMap一样的情况；
    //所以ConcurrentHashMap不是绝对的线程安全，为什么不写成绝对的线程安全的，可能是考虑到了性能问题；
    //所以一般情况下用ConcurrentHashMap可以达到线程安全的目的

    private static final int THREAD_POOL_SIZE = 100;

    private static Map<String, Integer> hashMap = Maps.newHashMap();
    private static Map<String, Integer> concurrentHashMap = Maps.newConcurrentMap();


    public synchronized void syncAdd(Map<String, Integer> map, String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, 1);
        } else {
            map.put(key, value + 1);
        }
    }

    public void add(Map<String, Integer> map, String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, 1);
        } else {
            map.put(key, value + 1);
        }
    }

    public void performTest(Map<String, Integer> map) throws InterruptedException {
        System.out.println("Test for " + map.getClass());

        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; ++j) {
                        //Integer randomNumber = (int) Math.ceil(Math.random() * 550000);

                        Integer value = map.get(String.valueOf(j));

                        if (map instanceof HashMap) {
                            syncAdd(map, String.valueOf(j));
                        } else if (map instanceof ConcurrentHashMap){
                            //syncAdd(map, String.valueOf(j));

                            add(map, String.valueOf(j));
                        }
                    }
                }
            });
        }

        executorService.shutdown();

        // Blocks until all tasks have completed execution after a shutdown request
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000L;
        System.out.println("Cost " + totalTime + " ms");

        //System.out.println(map);
    }


    public static void main(String[] args) throws InterruptedException {

        new HashMapVsConcurrentHashMap().performTest(hashMap);

        new HashMapVsConcurrentHashMap().performTest(concurrentHashMap);
    }

}
