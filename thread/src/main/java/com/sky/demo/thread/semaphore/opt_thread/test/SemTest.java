package com.sky.demo.thread.semaphore.opt_thread.test;

import com.sky.demo.thread.semaphore.opt_thread.DecThread;
import com.sky.demo.thread.semaphore.opt_thread.IncThread;

import java.util.concurrent.Semaphore;

/**
 * Created by rg on 15/6/28.
 */
public class SemTest {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new IncThread("Inc",sem);
        new DecThread("Dec",sem);

    }
}
