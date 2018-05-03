package ws.impl;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Service
@WebService(serviceName = "testService")
@SOAPBinding(parameterStyle= SOAPBinding.ParameterStyle.WRAPPED)
public class TestServiceImpl  {
    @WebMethod
    public String sayHi(String who) {
        return"Hi, " + who;
    }
}
