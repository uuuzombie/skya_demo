package com.sky.demo.interfaces.callback;


import com.sky.demo.interfaces.callback.consumer.CallbackImpl;
import com.sky.demo.interfaces.callback.consumer.Foo;
import com.sky.demo.interfaces.callback.producer.impl.FindCodeServiceImpl;
import com.sky.demo.interfaces.callback.producer.interfaces.ICallback;
import com.sky.demo.interfaces.callback.producer.interfaces.ICallbackService;
import org.junit.Test;

public class FooTest {

    @Test
    public void test_callback(){

        Foo foo = new Foo();
        ICallback callback = new CallbackImpl();
        ICallbackService callbackService = new FindCodeServiceImpl();

        foo.setCallback(callback);
        foo.setCallbackService(callbackService);

        foo.find();

    }
}
