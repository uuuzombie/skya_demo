package com.sky.demo.thread.sin.thread_local.static_action;

/**
 * Created by rg on 2015/10/4.
 */
public class StaticThread implements Runnable {

    @Override
    public void run() {
//        StaticAction.increase();      //非同步，实际运行结果为随机的数字
        StaticAction.syncIncrease();    //同步

        System.out.println(Thread.currentThread().getName() + ":" + StaticAction.getValue());
    }

    public static void main(String[] args) {

        int count = 1000;
        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(new StaticThread());
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(1000); //预留足够的时间让上面的线程跑完(如果值设置小了，则可能输出结果不是最后一个线程的)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(StaticAction.getValue());
    }
}
