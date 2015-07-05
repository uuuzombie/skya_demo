package com.sky.demo.util.observer;


import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update() called,count is " + ((Integer)arg).intValue());
    }
}
