package com.sky.demo.thread.java_thread.demo04;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread13Test {

    //2个线程持有同一个对象，会产生线程安全问题。
    //解决方法 synchronized
    public static void main(String[] args) {
        App13 app = new App13();

        DemoThread13_01 thread13_01 = new DemoThread13_01(app);
        DemoThread13_02 thread13_02 = new DemoThread13_02(app);

        thread13_01.start();
        thread13_02.start();

    }
}
