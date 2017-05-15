package com.sky.demo.thread.sin.future;

import com.google.common.util.concurrent.*;
import com.sky.demo.thread.sin.future.service.HttpService;
import com.sky.demo.thread.sin.future.service.RpcService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by user on 17/5/11.
 * 异步非阻塞
 * 全异步
 * Callback方式调用
 * 使用场景：不考虑回调时间且只能对结果做简单处理，如果依赖服务是两个或两个以上服务，则不能合并两个服务的处理结果;不阻塞主请求线程，但使用场景有限。
 * Guava ListenableFuture.addListener()
 */
public class AsyncNonBlockSample {

    private static final ListeningExecutorService LISTENING_EXECUTOR_SERVICE =
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());


    public static void main(String[] args) {

        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        try {
            long start = System.currentTimeMillis();

            ListenableFuture<Integer> listenableFutureRpc = LISTENING_EXECUTOR_SERVICE.submit(() -> {
                return rpcService.process();
            });

            ListenableFuture<Long> listenableFutureHttp = LISTENING_EXECUTOR_SERVICE.submit(() -> {
                return httpService.process();
            });


            //add call back
            Futures.addCallback(listenableFutureRpc, new FutureCallback<Integer>() {
                @Override
                public void onSuccess(Integer result) {
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            Futures.addCallback(listenableFutureHttp, new FutureCallback<Long>() {
                @Override
                public void onSuccess(Long result) {
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });


            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LISTENING_EXECUTOR_SERVICE.shutdown();
        }


    }


}
