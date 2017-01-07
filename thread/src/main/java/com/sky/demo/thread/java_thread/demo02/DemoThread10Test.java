package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread10Test {

    //两个在等待CPU的线程，优先级高的线程越容易被CPU选择执行
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            DemoThread10_1 t1 = new DemoThread10_1();
            t1.setPriority(10);
            t1.start();

            DemoThread10_2 t2 = new DemoThread10_2();
            t2.setPriority(1);
            t2.start();
        }
    }
}
