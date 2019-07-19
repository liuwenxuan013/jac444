package lab4;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class StudentInput {
	/**
	 * This is the function to read the input from the console
	 */
	public static void input() {

		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Students.bin")));

			System.out.println("------->Please enter the Student's information<--------");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);


			int studentID;
			String firstName;
			String lastName;
			ArrayList<String> courses= new ArrayList<String>();
			Boolean error;
				do {
					System.out.print("Student ID : ");
					scanner = new Scanner(System.in);
						studentID = scanner.nextInt();
						scanner.nextLine();		
					if(studentID <= 0) {
						error = true;
						System.out.println("Invalid Account Number! It Should be Positive.");
					} else {
						error = false;
					}
				} while(error == true);


				System.out.print("First Name : ");
				firstName = scanner.nextLine();


				System.out.print("Last Name : ");
				lastName = scanner.nextLine();

				System.out.print("Please entre courses, , type exit to quit:\n ");	
				
				int i=0;
				String readString = scanner.nextLine();
				while(!readString.toUpperCase().equals("EXIT") ) {
					if (!readString.isEmpty()) {
						courses.add(readString);
						readString = scanner.nextLine();
					}else {
							System.out.println("Please enter another course");
							readString = scanner.nextLine();		
						}
						
					
				}	




				/* *	
				 * creates an object of class Student
				 * */
				Student std = new Student(studentID, firstName, lastName, courses);

				/* *
				 * Write that object to File
				 * */
				oos.writeObject(std);

			oos.close();
			

		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage()); 
		}catch(IllegalArgumentException e) {
			System.out.println( e.getMessage());	
		}
			
	}
	
	
	public static void main(String[] args) {
		int menu = 0;
		do {
		System.out.println("------->Student's information system menu<--------");
		System.out.println("1. Add new student");
		System.out.println("2. verify the saved student data");
		System.out.println("0. Exit\n");
		System.out.print("Enter the menu number : ");

		Scanner scanner = new Scanner(System.in);
		 if(scanner.hasNext()) {
			 menu = scanner.nextInt();
			 scanner.nextLine();
			 
		 }
		 else {
			scanner= new Scanner(System.in);
		 	menu = scanner.nextInt();
			scanner.nextLine();		 
		 }
		switch(menu) {
		case 1:
			input();
			break;
		case 2:
			StudentOutput.readStudents();
			break;
		case 0:
			System.out.println("\nExit from the system\n");
			break;		
		default :
			System.out.println("Please enter a valid number\n");
			break;
		}
//		scanner.close();
		}while(menu == 1 || menu == 2);

	}
}
