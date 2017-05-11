package com.sky.demo.collect.map;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 17/5/11.
 */
public class HashMapVsConcurrentHashMapWithMyTask {

    private static final int THREAD_POOL_SIZE = 1000;
    private static final String KEY = "key";
    private static Object lock = new Object();


    public void performTestForMyTask(Map<String, Integer> map) throws InterruptedException {
        System.out.println("Test for " + map.getClass());

        long startTime = System.nanoTime();
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
            threadPool.execute(new MyTask(map));
        }

        threadPool.shutdown();

        // Blocks until all tasks have completed execution after a shutdown request
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000L;
        System.out.println("Cost " + totalTime + " ms");

        System.out.println(map);
    }




    public static class MyTask implements Runnable {

        private Map<String, Integer> map;

        public MyTask(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public void run() {

            for (int j = 0; j < 100; ++j) {
                if (map instanceof HashMap) {
//                    add(map, KEY);      //不安全
//                    syncAdd(map, KEY);  //不安全！

                    synchronized (lock) {  //安全
                        add(map, KEY);
                    }
                } else if (map instanceof ConcurrentHashMap) {
//                    add(map, KEY);      //不安全
//                    syncAdd(map, KEY);  //不安全！ synchronized锁住的是MyTask对象，每个线程的MyTask是独立的，上锁没意义

                    synchronized (lock) {  //安全
                        add(map, KEY);
                    }
                } else {
                    System.out.println("invalid instance");
                }
            }
        }

        //synchronized 锁this对象，即MyTask.class
        private synchronized void syncAdd(Map<String, Integer> map, String key) {
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }

        private void add(Map<String, Integer> map, String key) {

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
    }


    public static void main(String[] args) throws InterruptedException {

        new HashMapVsConcurrentHashMapWithMyTask().performTestForMyTask(Maps.newHashMap());
        new HashMapVsConcurrentHashMapWithMyTask().performTestForMyTask(Maps.newConcurrentMap());
    }
}
