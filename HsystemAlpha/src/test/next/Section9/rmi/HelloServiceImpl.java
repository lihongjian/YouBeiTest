package next.Section9.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
// Inherit UnicastRemoteObject and implement HelloService interface
public class HelloServiceImpl extends UnicastRemoteObject
        implements HelloService {

    private static final long serialVersionUID = 1L;
    private String name;

    public HelloServiceImpl(String name) throws RemoteException {
        super();
        this.name = name;
        // UnicastRemoteObject.exportObject(this, 0);
    }

    public String service(String data) throws RemoteException {
        return data + name;
    }
}