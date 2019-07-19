package student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;

public class Student {
    private String firstName;
    private String lastName;
    private Double grade;
    private String department;
    public Student(String fname, String lname,Double g, String dept){
        setFirstName(fname);
        setLastName(lname);
        setGrade(g);
        setDepartment(dept);
    }
    public void setFirstName(String fname){
        if(fname!=null)
            this.firstName=fname;
    }
    public void setLastName(String lname){
        if(lname!=null)
            this.lastName=lname;
    }
    public String getFirstName() {
        if (firstName != null)
            return firstName;
        return " - ";
    }
    public String getLastName() {
        if (lastName != null)
            return lastName;
        return " - ";
    }
    public void setGrade(Double g){
        if ( g > 0 )
            this.grade = g;
    }
    public Double getGrade() {
        return grade;
    }
    public void setDepartment(String dept){
        if(dept !=null)
            this.department = dept;
    }
    public String getDepartment(){
        if(department != null)
            return department;
        return " - ";
    }
    @Override
    public String toString(){
        return getFirstName()+" "+getLastName()+" "+getGrade()+" "+getDepartment();
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }
}


