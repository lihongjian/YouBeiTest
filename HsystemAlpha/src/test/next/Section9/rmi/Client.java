package next.Section9.rmi;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String url = "rmi://localhost:1099/";
        try {
            Context namingContext = new InitialContext();
            HelloService serv = (HelloService) namingContext.lookup(
                    url + "HelloService1");
            String data = "This is RMI Client.";
            System.out.println(serv.service(data));
        }
        catch (NamingException | RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
