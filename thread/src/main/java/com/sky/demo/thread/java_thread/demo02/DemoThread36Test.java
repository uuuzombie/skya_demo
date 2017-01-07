package com.sky.demo.thread.java_thread.demo02;

/**
 * Created by user on 17/1/7.
 */
public class DemoThread36Test {

    //join()方法会使调用join()方法的线程（也就是sub线程）所在的线程（也就是main线程）无限阻塞,
    //直到调用join()方法的线程销毁为止
    public static void main(String[] args) {

        try {
            DemoThread36 thread36 = new DemoThread36();
            thread36.start();
            thread36.join();        //join()方法的作用是等待线程销毁, join()方法内部使用的是wait()，因此会释放锁

            System.out.println("wait for sub thread...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
