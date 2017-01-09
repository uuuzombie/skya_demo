package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread18Test {

    //1、当A线程访问对象的synchronized代码块的时候，B线程依然可以访问对象方法中其余非synchronized块的部分
    //2、当A线程进入对象的synchronized代码块的时候，B线程如果要访问这段synchronized块，那么访问将会被阻塞
    public static void main(String[] args) {

        App18 app = new App18();

        DemoThread18 demoThread1 = new DemoThread18(app);
        DemoThread18 demoThread2 = new DemoThread18(app);
        demoThread1.start();
        demoThread2.start();

    }
}
