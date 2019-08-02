import java.io.Serializable;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
@SuppressWarnings("serial")
public class Car implements Serializable {

//public class Car extends UnicastRemoteObject {

    private String model;
    private String color;
    private double mileage;
    private String plate;
//    public Car() throws RemoteException {
//        super();
//        model = null;
//        color = null;
//        mileage = 0.0;
//        plate = null;
//    }

    public Car(String model, String color, double mile) {
        setModel(model);
        setColor(color);
        setMileage(mile);
        setPlate("Unregistered");
    }

    public void setModel(String model) {
        if (model != null)
            this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        if (color != null)
            this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setMileage(double mileage) {
        if (mileage > 0.0)
            this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public String toString() {
        return "Model: " + getModel() +
                "  Color: " + getColor() +
                "  Mileage: " + getMileage() +
                "  Plate: " + getPlate();
    }
}
