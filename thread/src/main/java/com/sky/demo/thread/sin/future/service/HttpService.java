package com.sky.demo.thread.sin.future.service;

import java.util.Random;

/**
 * Created by user on 17/5/11.
 */
public class HttpService {

    public Long process() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextLong();
    }

}
