package shapes;

public class Rectangle extends Parallelogram{
    public Rectangle(double width, double length) {
        super(width, length);
    }

    @Override
    public String toString() {
        return "Rectangle {w=" + getWidth() + ", h=" + getLength() + "} ";
    }
}