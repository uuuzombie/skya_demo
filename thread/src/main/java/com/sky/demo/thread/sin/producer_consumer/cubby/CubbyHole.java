package com.sky.demo.thread.sin.producer_consumer.cubby;

/**
 * Created by rg on 2014/6/23.
 */
public class CubbyHole {

    private int data;

    private volatile boolean getable = false;		//boolean 默认为false

    public synchronized int get() {

        while(!getable){
            try{
                wait();
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
        getable = false;

        notifyAll();
        return this.data;
    }

    public synchronized void put(int data) {
        while(getable){
            try{
                wait();
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
        this.data = data;
        getable = true;

        notifyAll();
    }
}
