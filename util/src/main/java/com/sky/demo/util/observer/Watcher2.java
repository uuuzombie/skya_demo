package com.sky.demo.util.observer;


import java.util.Observable;
import java.util.Observer;

public class Watcher2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (((Integer)arg).intValue() == 0){
            System.out.println("Done!!!");
        }
    }
}
