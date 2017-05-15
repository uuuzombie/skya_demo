package com.sky.demo.thread.sin.cyclic_barrier.test;

import com.sky.demo.thread.sin.cyclic_barrier.BarrierAction;
import com.sky.demo.thread.sin.cyclic_barrier.Worker;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by rg on 15/6/28.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new BarrierAction());

        System.out.println("Starting");
        new Worker("A",cyclicBarrier);
        new Worker("B",cyclicBarrier);
        new Worker("C",cyclicBarrier);

    }
}
