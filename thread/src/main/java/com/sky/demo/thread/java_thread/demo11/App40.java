package com.sky.demo.thread.java_thread.demo11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 17/1/9.
 */
public class App40 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    //producer
    public void conditionSignal() {

        try {
            lock.lock();

            System.out.println("condition signal time=" + System.currentTimeMillis());
            condition.signal();
//            condition.signalAll();
            System.out.println("condition signal end");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //consumer
    public void conditionAwait() {

        try {
            lock.lock();

            System.out.println("condition await time=" + System.currentTimeMillis());
            condition.await();
            System.out.println("condition await end");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
