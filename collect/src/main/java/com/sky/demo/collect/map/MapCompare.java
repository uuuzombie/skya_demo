package com.sky.demo.collect.map;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Maps;

/**
 * Created by rg on 11/22/15.
 */
public class MapCompare {

    public final static int THREAD_POOL_SIZE = 5;

    //Compare with Hashtable and SynchronizedMap and ConcurrentHashMap
    public static Map<String, Integer> hashTable = new Hashtable<>();
    public static Map<String, Integer> synchronizedMap = Collections.synchronizedMap(Maps.newHashMap());
    public static Map<String, Integer> concurrentHashMap = Maps.newConcurrentMap();

    public static void performTest(final Map<String, Integer> map) throws InterruptedException {

        System.out.println("Test started for: " + map.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {

            long startTime = System.nanoTime();
            ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                threadPool.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {
                        for (int i = 0; i < 500000; i++) {
                            Integer randomNumber = (int) Math.ceil(Math.random() * 550000);

                            // Retrieve value. We are not using it anywhere
                            Integer value = map.get(String.valueOf(randomNumber));

                            // Put value
                            map.put(String.valueOf(randomNumber), randomNumber);
                        }
                    }
                });
            }

            // Make sure executor stops
            threadPool.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + map.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }

    public static void main(String[] args) throws InterruptedException {

        // Test with Hashtable Object
        performTest(hashTable);

        // Test with synchronizedMap Object
        performTest(synchronizedMap);

        // Test with ConcurrentHashMap Object
        performTest(concurrentHashMap);

    }

}
