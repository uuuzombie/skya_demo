package com.sky.demo.interfaces.callback.consumer;


import com.sky.demo.interfaces.callback.producer.interfaces.ICallback;
import com.sky.demo.interfaces.callback.producer.interfaces.ICallbackService;

public class Foo {

    private ICallbackService callbackService;

    private ICallback callback;

    public ICallbackService getCallbackService() {
        return callbackService;
    }

    public void setCallbackService(ICallbackService callbackService) {
        this.callbackService = callbackService;
    }

    public ICallback getCallback() {
        return callback;
    }

    public void setCallback(ICallback callback) {
        this.callback = callback;
    }

    public void find(){

        callbackService.findCode(1,callback);

    }
}
