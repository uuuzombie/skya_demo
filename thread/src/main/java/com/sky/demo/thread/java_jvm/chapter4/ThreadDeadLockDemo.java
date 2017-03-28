package com.sky.demo.thread.java_jvm.chapter4;

/**
 * Created by user on 17/3/28.
 *
 * 线程死锁示例
 */
public class ThreadDeadLockDemo {


    static class SynAddTask implements Runnable {

        int a;
        int b;

        SynAddTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread1 = new Thread(new SynAddTask(1, 2));
            Thread thread2 = new Thread(new SynAddTask(2, 1));

            thread1.start();
            thread2.start();
        }
    }

}
