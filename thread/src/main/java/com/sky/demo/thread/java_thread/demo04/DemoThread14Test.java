package com.sky.demo.thread.java_thread.demo04;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread14Test {


    //1、A线程持有Object对象的Lock锁，B线程可以以异步方式调用Object对象中的非synchronized类型的方法
    //2、A线程持有Object对象的Lock锁，B线程如果在这时调用Object对象中的synchronized类型的方法则需要等待，也就是同步
    public static void main(String[] args) {

        App14 app = new App14();
        DemoThread14_01 thread14_01 = new DemoThread14_01(app);
        DemoThread14_02 thread14_02 = new DemoThread14_02(app);

        thread14_01.start();
        thread14_02.start();
    }
}
