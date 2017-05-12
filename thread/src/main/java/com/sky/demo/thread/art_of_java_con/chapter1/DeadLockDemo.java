package com.sky.demo.thread.art_of_java_con.chapter1;

/**
 * Created by user on 17/5/12.
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";


    public void deadLock() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (A) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (B) {
                        System.out.println("1");
                    }

                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (B) {

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }


    public static void main(String[] args) {

        new DeadLockDemo().deadLock();
    }
}
