package com.sky.demo.thread.producer_consumer.handler;


import com.sky.demo.thread.producer_consumer.model.CubbyHole;

public class Consumer extends Thread{

    private CubbyHole res;

    public Consumer(CubbyHole res) {
        this.res = res;
    }

    @Override
    public void run() {

        for(int i = 0;i < 10;++i){

            System.out.println("Consumer get " + res.get());

            try{
                sleep((int) (Math.random() * 100));
            } catch (Exception e) {

            }
        }

    }
}
