package com.sky.demo.thread.semaphore.prod_cons.test;

import com.sky.demo.thread.semaphore.prod_cons.Consumer;
import com.sky.demo.thread.semaphore.prod_cons.Producer;
import com.sky.demo.thread.semaphore.prod_cons.SemQueue;

/**
 * Created by rg on 15/6/28.
 */
public class SemTest {

    public static void main(String[] args) {
        SemQueue q = new SemQueue();
        new Consumer(q);
        new Producer(q);
    }
}
