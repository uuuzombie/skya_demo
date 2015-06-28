package com.sky.demo.thread.producer_consumer.handler;


import com.sky.demo.thread.producer_consumer.model.CubbyHole;

public class Producer extends Thread {

    private CubbyHole res;

    public Producer(CubbyHole res) {

        this.res = res;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            res.put(i);

            System.out.println("Producer put " + i);

            try{
                sleep((int)Math.random() * 100);
            } catch (Exception e){

            }
        }
    }
}
