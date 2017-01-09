package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread32Test {

    //notify()方法不释放锁
    public static void main(String[] args) {

        Object lock = new Object();

        DemoThread32_1 demoThread32_1 = new DemoThread32_1(lock);
        DemoThread32_2 demoThread32_2 = new DemoThread32_2(lock);

        demoThread32_1.start();
        demoThread32_2.start();

    }
}
