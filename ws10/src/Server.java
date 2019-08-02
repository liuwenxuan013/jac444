import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            CarInterface stub = new CarImp();
            LocateRegistry.createRegistry(7002);
            Naming.rebind("rmi://localhost:7002/Server", stub);
            System.out.println("***Server is Listening...");
        } catch (Throwable throwable) {
            System.out.println("Exception Message: " + throwable.getMessage());
            System.exit(1);
        }
    }
}