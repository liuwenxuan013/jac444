package shapes;

public class Circle implements Shape {
    private double radius;
    public  Circle(double radius){
        setRadius(radius);
    }

    public void setRadius(double radius) {
        if(radius > 0) this.radius = radius;
        else System.out.println("Invalid radius!");
    }

    public double getRadius() { return radius; }

    public double getPerimeter() { return 2 * getRadius() * Math.PI; }

    public String toString() { return getClass().getName()+ " {r=" + getRadius() + "} ";}
}