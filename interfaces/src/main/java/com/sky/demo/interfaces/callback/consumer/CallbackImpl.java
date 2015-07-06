package com.sky.demo.interfaces.callback.consumer;


import com.sky.demo.interfaces.callback.producer.interfaces.ICallback;

public class CallbackImpl implements ICallback {

    @Override
    public void process(int code) {
        System.out.println("callback process,code=" + code);
    }
}
