package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread03Test {

    //调用start()方法的顺序不代表线程启动的顺序，线程启动顺序具有不确定性
    public static void main(String[] args) {

        DemoThread03 t1 = new DemoThread03();
        DemoThread03 t2 = new DemoThread03();
        DemoThread03 t3 = new DemoThread03();

        t1.start();
        t2.start();
        t3.start();

    }
}
