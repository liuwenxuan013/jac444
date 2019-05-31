package shapes;

public class Parallelogram implements Shape {
    private double width = 0;
    private double length = 0;

    public Parallelogram(double w, double l) {
        super();
        if (w > 0 && l > 0) {
            setWidth(w);
            setLength(l);
        }
        else System.out.println("Invalid side!");
    }

    public void setWidth(double w) {
        if (w > 0) width = w;
    }

    public double getWidth() {
        return width;
    }
    public void setLength(double l) {
        if (l > 0) length = l;
    }

    public double getLength() {
        return length;
    }
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public String toString() {
        return "Parallelogram {w=" + getWidth() + ", h=" + getLength() + "} ";
    }
}



