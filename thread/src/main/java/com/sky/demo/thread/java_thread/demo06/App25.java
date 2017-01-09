package com.sky.demo.thread.java_thread.demo06;

/**
 * Created by user on 17/1/9.
 */
public class App25 {

    public synchronized static void syncStaticMethodA() {
        try {
            System.out.println("Thread name=" + Thread.currentThread().getName() + " enter sync static method A");
            Thread.sleep(2000);
            System.out.println("Thread name=" + Thread.currentThread().getName() + " leave sync static method A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized static void syncStaticMethodB() {
        try {
            System.out.println("Thread name=" + Thread.currentThread().getName() + " enter sync static method B");
            Thread.sleep(2000);
            System.out.println("Thread name=" + Thread.currentThread().getName() + " leave sync static method B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void syncMethodC() {
        try {
            System.out.println("Thread name=" + Thread.currentThread().getName() + " enter sync static method C");
            Thread.sleep(2000);
            System.out.println("Thread name=" + Thread.currentThread().getName() + " leave sync static method C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
