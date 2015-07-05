package com.sky.demo.util.observer;

import org.junit.Test;

/**
 * Created by rg on 15/7/5.
 */
public class ObserverTest {

    @Test
    public void test_Observer(){

        BeingWatched beingWatched = new BeingWatched();
        Watcher watcher = new Watcher();
        Watcher2 watcher2 = new Watcher2();

        beingWatched.addObserver(watcher);
        beingWatched.addObserver(watcher2);

        beingWatched.counter(10);
    }
}
