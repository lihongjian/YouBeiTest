package ws;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)  
public interface HelloWorld {
    String sayHi(@WebParam(name = "who") String who);

    String sayHello(@WebParam(name = "who") String who);
}  