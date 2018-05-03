package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
//@WebService(endpointInterface = "com.conquer.comutils.core.jws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @WebMethod// 默认的，可省略
    @Override
    public String sayHi(String who) {
        return "hi, " + who;
    }

    // 排除的方法
    @WebMethod(exclude = true)
    @Override
    public String sayHello(@WebParam(name = "who") String who) {
        return "hello, " + who;
    }
}