package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread19Test {

    //同一个对象的两个synchronized块之间具有互斥性
    //synchronized块获得的是一个对象锁，换句话说，synchronized块锁定的是整个对象。
    public static void main(String[] args) {
        App19 app = new App19();

        DemoThread19_1 demoThread19_1 = new DemoThread19_1(app);
        DemoThread19_2 demoThread19_2 = new DemoThread19_2(app);

        demoThread19_1.start();
        demoThread19_2.start();
    }
}
