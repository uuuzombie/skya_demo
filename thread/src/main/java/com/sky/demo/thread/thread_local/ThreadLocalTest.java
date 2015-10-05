package com.sky.demo.thread.thread_local;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadLocalTest {

//    public static ThreadLocal<String> QT = new InheritableThreadLocal<String>();
//    public static ThreadLocal<String> QT = new ThreadLocal<String>();
    public static String QT = null;

    public static void main(String[] args) {

        int count = 1000;

        for (int i = 0; i < count; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    QT = String.valueOf(finalI);
                    System.out.println(Thread.currentThread().getName() + ":" + QT);

//                    QT.set(str);
//                    System.out.println(Thread.currentThread().getName() + ":" + QT.get());
                }
            }).start();
        }
    }
}
