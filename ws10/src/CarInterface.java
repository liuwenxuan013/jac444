
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface CarInterface extends Remote {
    public String carRegister(Car car) throws RemoteException;
}

