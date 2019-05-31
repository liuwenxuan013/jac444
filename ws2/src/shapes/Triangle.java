package shapes;

public class Triangle implements Shape {
    private double s1;
    private double s2;
    private double s3;

    public Triangle(double a, double b, double c) {
        if(valid( a,b,c )) {
            setA(a);
            setB(b);
            setC(c);
        }
        else System.out.println("Invalid side(s)!");
    }

    public void setA(double a) {
        if(a > 0) s1 = a;
    }
    public double getA() {
        return s1;
    }

    public void setB( double b ) {
        if(b > 0) s2 = b;
    }
    public double getB() {
        return s2;
    }

    public void setC( double c ) {
        if(c > 0) s3 = c;
    }

    public double getC() {
        return s3;
    }

    public boolean valid(double a, double b, double c) {
        boolean v = true;
        if (a <= 0 || b <= 0 || c <= 0) {
            v = false;
        } else if (((a + b) < c) || ((a + c) < b) || ((b + c) < a))
            v= false;
        return v;
    }

    public double getPerimeter() {
        return getA() + getB() + getC();
    }

    public String toString() {
        return "Triangle {s1=" + getA() + ", s2=" + getB() + ", s3=" + getC() + "} ";
    }
}