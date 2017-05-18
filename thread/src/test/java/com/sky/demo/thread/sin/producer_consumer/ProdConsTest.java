package com.sky.demo.thread.sin.producer_consumer;

import com.sky.demo.thread.sin.producer_consumer.cubby.Consumer;
import com.sky.demo.thread.sin.producer_consumer.cubby.CubbyHole;
import com.sky.demo.thread.sin.producer_consumer.cubby.Producer;
import org.junit.Test;

/**
 * Created by rg on 15/6/28.
 */
public class ProdConsTest {

    //每次运行结果不一致？
    @Test
    public void test_ProCon(){
        CubbyHole res = new CubbyHole();
        Producer producer = new Producer(res);
        Consumer consumer = new Consumer(res);

        producer.start();
        consumer.start();
    }
}
