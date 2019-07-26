package senecacollege;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentOutput {
    public static void readStudents() {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Students.bin"));
            int x = 0;
            while(ois != null) {

                Student std = (Student) ois.readObject();
                x++;
                System.out.println("\nStudent Information " + x);
                System.out.println("Student ID: " + std.getStdID());
                System.out.println("First Name: " + std.getStdFirstName());
                System.out.println("Last Name: " + std.getStdLastName());
                System.out.println("Courses: " + std.getStdCourses());
            }
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
