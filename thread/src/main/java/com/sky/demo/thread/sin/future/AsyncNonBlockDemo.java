package com.sky.demo.thread.sin.future;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.CompletableFuture;

/**
 * Created by user on 17/5/11.
 * 异步非阻塞
 * 全异步
 * Callback方式调用
 * 使用场景：不考虑回调时间且只能对结果做简单处理，如果依赖服务是两个或两个以上服务，则不能合并两个服务的处理结果;不阻塞主请求线程，但使用场景有限。
 * 另：Guava ListenableFuture.addListener()
 */
public class AsyncNonBlockDemo {
    // 设置HTTP请求的超时配置
    private static RequestConfig config = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();
    // 根据配置创建异步的HTTP客户端
    private static CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom().setDefaultRequestConfig(config).build();

    static {
        httpAsyncClient.start();
    }

    public static CompletableFuture<String> getHttpData(String url) {
        CompletableFuture asyncFuture = new CompletableFuture();
        HttpPost post = new HttpPost(url);

        HttpAsyncRequestProducer producer = HttpAsyncMethods.create(post);

        AsyncCharConsumer<HttpResponse> consumer = new AsyncCharConsumer<HttpResponse>() {
            HttpResponse response;

            @Override
            protected void onResponseReceived(HttpResponse response) throws HttpException, IOException {

            }

            @Override
            protected HttpResponse buildResult(final HttpContext context) {
                return response;
            }

            @Override
            protected void onCharReceived(CharBuffer buf, IOControl ioctrl) throws IOException {

            }
            //...
        };

        FutureCallback callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                try {
                    asyncFuture.complete(EntityUtils.toString(response.getEntity()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Exception ex) {

            }

            @Override
            public void cancelled() {

            }
            //...
        };
        httpAsyncClient.execute(producer, consumer, callback);
        return asyncFuture;
    }

    public static void main(String[] args) throws Exception {
        AsyncNonBlockDemo.getHttpData("http://www.sina.com");
        Thread.sleep(100000);
    }
}
