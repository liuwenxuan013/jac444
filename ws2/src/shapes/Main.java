package shapes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String s;
        int count = 0;
        Shape[] shapes = new Shape[100];
        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt")))
        {

            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");
                if(tokens[0].toUpperCase().equals("CIRCLE") && tokens.length == 2) {
                    Circle temp = new Circle(Double.parseDouble(tokens[1]));
                    if(temp.getRadius() != 0) shapes[count++] = temp;
                }

                else if(tokens[0].toUpperCase().equals("SQUARE") && tokens.length == 2) {
                    Square temp = new Square(Double.parseDouble(tokens[1]));
                    if(temp.getWidth() != 0) shapes[count++] = temp;
                }


                else if(tokens[0].toUpperCase().equals("RECTANGLE") && tokens.length == 3) {
                    Rectangle temp = new Rectangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
                    if(temp.getLength() != 0 && temp.getWidth() != 0) shapes[count++] = temp;
                }

                else if(tokens[0].toUpperCase().equals("PARALLELOGRAM") && tokens.length == 3) {
                    Parallelogram temp = new Parallelogram(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
                    if(temp.getLength() != 0 && temp.getWidth() != 0) shapes[count++] = temp;
                }
                else if(tokens[0].toUpperCase().equals("TRIANGLE") && tokens.length == 4) {
                    Triangle temp = new Triangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                    if(temp.valid(temp.getA(),temp.getB(),temp.getC())) shapes[count++] = temp;
                }
            }
            System.out.println();
            System.out.println(count + " shapes were created:");
            for(int i = 0; i < count; i++) {
                System.out.print(shapes[i]);
                System.out.printf("perimeter = %g%n", shapes[i].getPerimeter());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

