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

    //ConcurrentHashMap的线程安全指的是，它的每个方法单独调用（即原子操作）都是线程安全的，但是代码总体的互斥性并不受控制

    private static final int THREAD_POOL_SIZE = 1000;

    private static Map<String, Integer> hashMap = Maps.newHashMap();
    private static Map<String, Integer> concurrentHashMap = Maps.newConcurrentMap();

    private static final String KEY = "key";
    private static Object lock = new Object();

    public synchronized void syncAdd(Map<String, Integer> map, String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, 1);
        } else {
            map.put(key, value + 1);
        }
    }

    public void add(Map<String, Integer> map, String key) {

        //并不是原子操作，它包含了三步：
        //1.map.get
        //2.加1
        //3.map.put
        //其中第1和第3步，单独来说都是线程安全的，由ConcurrentHashMap保证。但是由于在上面的代码中，map本身是一个共享变量。
        //当线程A执行map.get的时候，其它线程可能正在执行map.put，这样一来当线程A执行到map.put的时候，线程A的值就已经是脏数据了，然后脏数据覆盖了真值，导致线程不安全

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
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {

                    for (int j = 0; j < 100; ++j) {
                        if (map instanceof HashMap) {
                            syncAdd(map, KEY);
                        } else if (map instanceof ConcurrentHashMap) {
                            //syncAdd(map, KEY);  //ConcurrentHashMap 用关键字synchronized修饰add方法,运行之后仍然是线程不安全的 ?

                            //add(map, KEY);  //不安全

                            synchronized (lock) {  //安全
                                add(map, KEY);
                            }
                        }
                    }
                }
            });
        }

        threadPool.shutdown();

        // Blocks until all tasks have completed execution after a shutdown request
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000L;
        System.out.println("Cost " + totalTime + " ms");

        System.out.println(map);
    }


    public static void main(String[] args) throws InterruptedException {

        new HashMapVsConcurrentHashMap().performTest(hashMap);

        new HashMapVsConcurrentHashMap().performTest(concurrentHashMap);
    }

}
