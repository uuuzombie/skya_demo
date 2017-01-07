package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread04Test {

    //线程类的构造方法、静态块是被main线程调用的，而线程类的run()方法才是应用线程自己调用的
    public static void main(String[] args) {
        DemoThread04 thread04 = new DemoThread04();
        thread04.start();

    }
}
