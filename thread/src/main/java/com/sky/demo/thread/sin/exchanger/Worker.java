package com.sky.demo.thread.sin.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by rg on 15/6/28.
 */
public class Worker implements Runnable {
    Exchanger<String> ex;
    String str;

    public Worker(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += (char)ch++;
            }

            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
