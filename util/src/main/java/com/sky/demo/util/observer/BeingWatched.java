package com.sky.demo.util.observer;


import java.util.Observable;

public class BeingWatched extends Observable {

    public void counter(int period){
        for (;period >= 0;period--){
            setChanged();
            notifyObservers(new Integer(period));

            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
