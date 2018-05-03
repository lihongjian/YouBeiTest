package next.Section9.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
// Inherit the java.rmi.Remote interface
public interface HelloService extends Remote {
    // Remote method should throw RemoteException
    public String service(String data) throws RemoteException;
}
