import java.rmi.*;

public class Clients {

    public static void main(String[] args) throws java.rmi.RemoteException {
        Car[] cars = new Car[3];
        cars[0] = new Car("BMW X6", "White", 2000);
        cars[1] = new Car("Porsche 911", "Black", 1000);
        cars[2] = new Car("Audi R8", "Red", 3000);

        for (int count = 0; count < 3; count++) {
            System.out.println("\n---------Register Request--------->\n\t" + cars[count].toString());

            try {
                CarInterface stub = (CarInterface) Naming.lookup("rmi://localhost:7002/Server");
                cars[count].setPlate(stub.carRegister(cars[count]));
                System.out.println("\n---------Register Response--------->\n\t" + cars[count].toString()+ "\n");

            } catch (Throwable throwable) {
                System.out.println("Exception Message: " + throwable.getMessage());
            }
        }
        System.out.println("***Register Request Clear!***");
    }
}

