package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread05Test {

    //当前执行的Thread未必就是Thread本身
    //（1）执行DemoThread05构造方法是main，当前线程却是Thread-0
    //（2）执行run()方法的Thread-0，当前线程也是Thread-0，说明run()方法就是被线程实例去执行的
    public static void main(String[] args) {

        DemoThread05 thread05 = new DemoThread05();
        thread05.start();
    }
}
