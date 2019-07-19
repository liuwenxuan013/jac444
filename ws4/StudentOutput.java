package lab4;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentOutput {
	public static void readStudents() {
		try {		

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Students.bin"));
			int index = 0;
			while(ois != null) {

				/* *
				 * instance of object got created to read perticular data from file
				 * */
				Student std = (Student) ois.readObject();

				index++;
				/* *
				 * Information of Student in Perticualr Format
				 * */
				System.out.println("\nStudent Information " + index);
				System.out.println("Student ID: " + std.getStudentID());
				System.out.println("First Name: " + std.getStudenFirstName());
				System.out.println("Last Name: " + std.getStudenLastName());
				System.out.println("Courses: " + std.getStudentCourses());
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
