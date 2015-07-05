package com.sky.demo.util;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

/**
 * Created by rg on 15/7/5.
 */
public class StopWatchTest {

    private static final StopWatch watch = new StopWatch();
    private static final long SLEEP_TIME = 1000;

    @Test
    public void test_stop_watch() {
        watch.start();
        System.out.println("start :" + watch );

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        watch.split();
        System.out.println("sleep " + SLEEP_TIME );
        System.out.println("now  :" + watch );
        System.out.println("now split time :" + watch.getSplitTime());

    }
}
