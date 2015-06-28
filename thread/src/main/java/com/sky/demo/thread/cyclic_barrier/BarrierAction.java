package com.sky.demo.thread.cyclic_barrier;

/**
 * Created by rg on 15/6/28.
 */
public class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier reached");
    }
}
