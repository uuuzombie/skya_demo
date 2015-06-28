package com.sky.demo.thread.count_down_latch.worker_boss;

import org.junit.Test;

/**
 * Created by rg on 15/6/28.
 */
public class CountDownLatchTest {

    //线程测试会有问题
    @Test
    public void test_CountDownLatch(){
        /*
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Worker worker1 = new Worker(countDownLatch,"work1");
        Worker worker2 = new Worker(countDownLatch,"work2");
        Worker worker3 = new Worker(countDownLatch,"work3");
        Boss boss = new Boss(countDownLatch);

        executor.execute(worker1);
        executor.execute(worker2);
        executor.execute(worker3);
        executor.execute(boss);

        executor.shutdown();
        */
    }
}
