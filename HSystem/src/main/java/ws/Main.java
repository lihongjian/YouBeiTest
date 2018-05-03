package ws;

import javax.xml.ws.Endpoint;

public class Main {

    static final String ADDRESS = "http://localhost:8080/test/jaxws/services/HelloWorld";

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImpl();
        Endpoint.publish(ADDRESS, helloWorld);
        System.out.println("JAX-WS WebService 服务已启动");
    }
}
