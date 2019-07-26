package senecacollege;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    public Student(int stdID,
                   String firstName,
                   String lastName,
                   ArrayList<String> courses)
    {
        this.stdID = stdID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public int getStdID() {
        return stdID;
    }

    public void setStdID(int stdID) throws IllegalAccessException{
        if(stdID <0)
            throw new IllegalArgumentException("Invalide Student Account!");
        this.stdID = stdID;
    }

    public String getStdFirstName() {

        return firstName;
    }


    public String getStdLastName() {

        return lastName;
    }

    public ArrayList<String> getStdCourses() {

        return courses;
    }





}
