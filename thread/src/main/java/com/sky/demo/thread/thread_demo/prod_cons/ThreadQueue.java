package com.sky.demo.thread.thread_demo.prod_cons;

/**
 * Created by guang.rong on 2014/9/14.
 */
public class ThreadQueue {

    int n;
    boolean valueSet = false;

    synchronized int get(){
        if (!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got :" + n);

        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        if (valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.n = n;
        valueSet = true;
        System.out.println("Put :" + n);
        notify();
    }

}
