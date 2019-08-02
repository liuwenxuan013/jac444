import java.rmi.*;
import java.rmi.server.*;

@SuppressWarnings("serial")
public class CarImp extends UnicastRemoteObject implements CarInterface {
    protected CarImp() throws RemoteException {
        super();
    }
    @Override
    public String carRegister(Car c) throws RemoteException {
        return " " + c.hashCode();
    }
}
