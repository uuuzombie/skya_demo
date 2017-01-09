package com.sky.demo.thread.java_thread.demo08;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread30Test {

    //wait()方法可以使调用该线程的方法释放共享资源的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒。
    //notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态。
    //notifyAll()方法可以使所有正在等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态。
    public static void main(String[] args) {
        try {
            Object lock = new Object();

            DemoThread30_1 demoThread30_1 = new DemoThread30_1(lock);
            DemoThread30_2 demoThread30_2 = new DemoThread30_2(lock);

            demoThread30_1.start();

            Thread.sleep(2000);

            demoThread30_2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
