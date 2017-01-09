package com.sky.demo.thread.java_thread.demo06;

import com.sky.demo.thread.java_thread.demo05.DemoThread20_2;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread25Test {

    //静态同步方法和非静态同步方法持有的是不同的锁，前者是类锁，后者是对象锁。
    public static void main(String[] args) {
        App25 app = new App25();

        DemoThread25_1 demoThread25_1 = new DemoThread25_1();
        DemoThread25_2 demoThread25_2 = new DemoThread25_2();
        DemoThread25_3 demoThread25_3 = new DemoThread25_3(app);

        demoThread25_1.start();
        demoThread25_2.start();
        demoThread25_3.start();
    }
}
