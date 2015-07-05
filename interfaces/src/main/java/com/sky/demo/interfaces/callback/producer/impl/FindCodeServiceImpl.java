package com.sky.demo.interfaces.callback.producer.impl;


import com.sky.demo.interfaces.callback.producer.interfaces.ICallback;
import com.sky.demo.interfaces.callback.producer.interfaces.ICallbackService;

public class FindCodeServiceImpl implements ICallbackService {
    @Override
    public void findCode(int id, ICallback callback) {
        System.out.println("producer id:" + id);

        long time = 2000L;
        try {
            System.out.println("process time:" + time);
            Thread.sleep(time);
            System.out.println("call back");
            callback.process(id);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
