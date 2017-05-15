package com.sky.demo.thread.sin.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by rg on 15/6/28.
 */
public class Receiver implements Runnable {
    Exchanger<String> ex;
    String str;

    public Receiver(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Got :" + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
