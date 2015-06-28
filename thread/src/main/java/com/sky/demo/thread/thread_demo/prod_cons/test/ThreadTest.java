package com.sky.demo.thread.thread_demo.prod_cons.test;

import com.sky.demo.thread.thread_demo.prod_cons.Consumer;
import com.sky.demo.thread.thread_demo.prod_cons.Producer;
import com.sky.demo.thread.thread_demo.prod_cons.ThreadQueue;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadQueue q = new ThreadQueue();

        new Producer(q);
        new Consumer(q);

        System.out.println("Ctrl + F2 to stop");
    }
}
