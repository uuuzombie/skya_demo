package com.sky.demo.thread.thread_demo.common_thread;

import org.junit.Test;

/**
 * Created by rg on 15/6/28.
 */
public class PrintTest {

    @Test
    public void test_PrintThread(){

        PrintThread pthread1,pthread2,pthread3,pthread4;

        pthread1 = new PrintThread("Thread1");
        pthread2 = new PrintThread("Thread2");
        pthread3 = new PrintThread("Thread3");
        pthread4 = new PrintThread("Thread4");

        System.out.println( "\nStarting threads" );

        pthread1.start();
        pthread2.start();
        pthread3.start();
        pthread4.start();

        System.out.println("Threads started");
    }

    @Test
    public void test_PrintRunnable(){
        PrintRunnable thread1,thread2,thread3,thread4;

        thread1 = new PrintRunnable("Thread1");
        thread2 = new PrintRunnable("Thread2");
        thread3 = new PrintRunnable("Thread3");
        thread4 = new PrintRunnable("Thread4");

        System.out.println( "\nStarting threads" );

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
        new Thread(thread4).start();

        System.out.println( "Threads started\n" );
    }


}
