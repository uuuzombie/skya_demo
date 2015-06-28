package com.sky.demo.thread.thread_demo.common_thread;

/**
 * Created by rg on 2014/6/24.
 */
public class PrintRunnable implements Runnable {

    private String name;
    private int sleepTime;

    public PrintRunnable(String name){
        this.name = name;

        sleepTime = (int) ( Math.random() * 5000 );
        System.out.println( "Name: " + name + ";  sleep: " + sleepTime );
    }

    @Override
    public void run() {
        try{
            System.out.println(name + "going to sleep");
            Thread.sleep(sleepTime);
        } catch (InterruptedException ie ){
            System.err.println( ie.toString() );
        }
        System.out.println(name + "done sleeping");
    }
}
