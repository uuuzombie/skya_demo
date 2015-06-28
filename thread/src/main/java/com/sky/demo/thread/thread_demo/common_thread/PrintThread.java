package com.sky.demo.thread.thread_demo.common_thread;

/**
 * Created by rg on 2014/6/24.
 */
public class PrintThread extends Thread {       //继承Thread

    private int sleepTime;

    public PrintThread(String name){

        super(name);

        sleepTime = (int)(Math.random() * 5000);
        System.out.println("Name:" + getName() + "; sleep:" + sleepTime);
    }

    public void run() {
        try{
            System.out.println(getName() + "going to sleep");
            Thread.sleep(sleepTime);
        } catch (InterruptedException ie) {
            System.err.println(ie.toString());
        }
        System.out.println(getName() + "done sleeping" );
    }

}
