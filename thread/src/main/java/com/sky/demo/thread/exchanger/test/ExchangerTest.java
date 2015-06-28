package com.sky.demo.thread.exchanger.test;

import com.sky.demo.thread.exchanger.Worker;
import com.sky.demo.thread.exchanger.Receiver;

import java.util.concurrent.Exchanger;

/**
 * Created by rg on 15/6/28.
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();

        new Worker(exchanger);
        new Receiver(exchanger);
    }
}
