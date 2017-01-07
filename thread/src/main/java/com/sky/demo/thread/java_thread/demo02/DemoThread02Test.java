package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread02Test {

    //CPU执行哪个线程的代码具有不确定性
    public static void main(String[] args) {
        DemoThread02 thread02 = new DemoThread02();
        thread02.start();
//        thread02.run();       //只有run()而不调用start()启动线程是没有任何意义的

        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep((int)Math.random() * 1000);
                System.out.println("run : " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
