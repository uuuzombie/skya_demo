package com.sky.demo.thread.sin.semaphore.prod_cons;

import java.util.concurrent.Semaphore;

/**
 * Created by rg on 2014/9/14.
 */
public class SemQueue {

    int n;

    Semaphore semCon = new Semaphore(0);        //消费者信号量，初始0
    Semaphore semProd = new Semaphore(1);       //生产者信号量，初始1

    void put(int n){
        try {
            semProd.acquire();
            this.n = n;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("Put :" + n);
            semCon.release();
        }
    }

    void get(){

        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Get :" + n);
            semProd.release();
        }
    }

}
