package person.li.controller;

import Hsystem.base.annotation.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import person.li.vo.httpclient.HttpClientChildVo;
import person.li.vo.httpclient.HttpClientVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

@Controller
public class HttpClientTestController {

    /**
     * json转换单个复杂的参数 使用Requestboby可以实现
     * 但是多个参数则不行
     * @param hc
     */
    @RequestMapping(value = "/httpClientParamTest")
    @ResponseBody
    public void httpClientParamTest(@RequestBody HttpClientVo hc){

        System.out.println(hc.getCode());
        System.out.println(hc.getName());

    }

    /**
     * 多个参数 使用自定义的JsonObject 和自定义的JsonObjectArgResolverHandler 可以实现
     * @param hc
     * @param hcchild
     */
    @RequestMapping(value = "/httpClientParamTest2")
    @ResponseBody
    public void httpClientParamTest2(@JsonObject HttpClientVo hc, @JsonObject HttpClientChildVo hcchild){

        System.out.println(hc.getCode());
        System.out.println(hc.getName());
        System.out.println(hcchild.getName());
        System.out.println(hcchild.getCode());

    }

    /**
     * httpClient 返回值测试
     * @param abc
     */
    @RequestMapping(value = "/httpClientReturnTest")
    @ResponseBody
    public HttpClientVo httpClientReturnTest(String abc){
        HttpClientVo hc = new HttpClientVo();
        hc.setName("hc name1 ");
        hc.setCode("hc code1 ");
        List<HttpClientChildVo> hcchildvos = new ArrayList<HttpClientChildVo>();
        hc.setHttpClientChildVos(hcchildvos);
        HttpClientChildVo hcchild1 = new HttpClientChildVo();
        hcchild1.setName("hc hcchild name1 ");
        hcchild1.setCode("hc hcchild code1 ");
        hcchildvos.add(hcchild1);
        return hc;
    }

    /**
     * httpclient
     * @return
     */
    @RequestMapping(value = "/httpclientTest")
    @ResponseBody
    public String httpclientTest() {
        long a1 = System.currentTimeMillis();
        CloseableHttpClient chc = null;
        String result = null;
        try {
            chc = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000).setConnectionRequestTimeout(1000).setSocketTimeout(1000).build();
            for(int i = 0 ; i < 10 ; i ++){
                String url = "http://localhost:8080/serverForHttpClientTest?data=" + "testTimes" + i;
                HttpGet httpGet = new HttpGet(url);
                httpGet.setConfig(requestConfig);
                chc.execute(httpGet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long a2 = System.currentTimeMillis();
        System.out.println("httpclienttest cost time : " + (a2 - a1));
        return "SUCCESS";
    }

    /**
     * 异步httpclient
     * @return
     */
    @RequestMapping(value = "/asynhttpclientTest")
    @ResponseBody
    public String asynhttpclientTest() {
        long a1 = System.currentTimeMillis();
        CloseableHttpAsyncClient httpclient = null;
        try {
//            httpclient = HttpAsyncClients.createDefault();


            // Start the client
            // Execute request
            final CountDownLatch latch1 = new CountDownLatch(10);
/*
            RequestConfig rc = RequestConfig.custom().setConnectionRequestTimeout(1000).setConnectTimeout(1000).setSocketTimeout(1000).build();
*/          Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder.<SchemeIOSessionStrategy>create().register("http",NoopIOSessionStrategy.INSTANCE).build();
                    IOReactorConfig ioReactorConfig = IOReactorConfig
                    .custom()
                    .setIoThreadCount(12)
                    .build();
            ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
            PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(
                    ioReactor, null, sessionStrategyRegistry, null);
            connManager.setMaxTotal(100);
            connManager.setDefaultMaxPerRoute(100);
            httpclient = HttpAsyncClients.custom().setConnectionManager(connManager).build();
            httpclient.start();

            for( int i= 0 ; i < 10 ; i ++){
                HttpGet request2 = new HttpGet("http://localhost:8080/serverForHttpClientTest?data=" + "testTimes" + i);
//                request2.setConfig(rc);
                httpclient.execute(request2, new FutureCallback<HttpResponse>() {
                    public void completed(final HttpResponse response2) {
                        latch1.countDown();
                    }
                    public void failed(final Exception ex) {
                        latch1.countDown();
                    }
                    public void cancelled() {
                        latch1.countDown();
                    }
                });
            }
            for(int i = 0 ; i < 10 ; i ++){
                try {
                    Thread.sleep(500);
                    System.out.println("asynhttpclientTest running ..." + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           latch1.await();
            long a2 = System.currentTimeMillis();
            System.out.println("asynhttpclientTest cost time : " + (a2 - a1));
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "SECOND SUCCESS !";
    }


    @RequestMapping(value = "/serverForHttpClientTest",method= RequestMethod.DELETE)
    @ResponseBody
    public String serverForHttpClientTest(String data) {
        System.out.println(" data received : " + data);
        for(int i = 0 ; i < 10 ; i ++){
            try {
                Thread.sleep(500);
                System.out.println("serverForHttpClientTest running ..." + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "ABC";
    }

}
