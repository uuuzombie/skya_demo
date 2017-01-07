package com.sky.demo.thread.java_thread.demo03;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread08Test {


    //yield() 暂停当前执行的线程对象，并执行其他线程。这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定
    public static void main(String[] args) {
        DemoThread08 thread08 = new DemoThread08();
        thread08.start();
    }
}
