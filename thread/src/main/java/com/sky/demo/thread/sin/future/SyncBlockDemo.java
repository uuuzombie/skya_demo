package com.sky.demo.thread.sin.future;

import com.sky.demo.thread.sin.future.service.HttpService;
import com.sky.demo.thread.sin.future.service.RpcService;

import java.util.Random;

/**
 * Created by user on 17/5/11.
 * 同步阻塞
 * 即串行调用，响应时间为所有服务的响应时间总和;
 */
public class SyncBlockDemo {



    public static void main(String[] args) {

        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        try {
            long start = System.currentTimeMillis();

            Integer integer = rpcService.process();
            System.out.println(integer);

            Long value = httpService.process();
            System.out.println(value);

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
