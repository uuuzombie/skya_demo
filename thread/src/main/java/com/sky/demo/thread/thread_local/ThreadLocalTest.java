package com.sky.demo.thread.thread_local;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadLocalTest {

    public static InheritableThreadLocal<String> QT = new InheritableThreadLocal<String>();

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InheritableThreadLocal<String> QT = new InheritableThreadLocal<String>();
                    QT.set(String.valueOf(finalI));
                }
            }).start();
        }
    }
}
