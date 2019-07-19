package student;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class StudentProcess {
    public static void main(String[] args) {
        try{

            Student[] students = {
                    new Student("Jack", "Smith", 50.0, "IT"),
                    new Student("Aaron", "Johnson", 76.0, "IT"),
                    new Student("Maaria", "White", 35.8, "Business"),
                    new Student("John", "White", 47.0, "Media"),
                    new Student("Laney", "White", 62.0, "IT"),
                    new Student("Jack", "Jones", 32.9, "Business"),
                    new Student("Wesley", "Jones", 42.89, "Media")
            };
            List<Student> studentList = Arrays.asList(students);
//            System.out.println("=========  Task 1  =========\n");
//            System.out.println("Student full name sorted by last names then first name:");
//            studentList
//                    .stream()
//                    .forEach(System.out::println);
//            System.out.println("\n");
//            System.out.println("=========  Task 2  =========\n");
//            System.out.println("Students with grade in the range 50.0-100.0, sorted grade:");
//            studentList
//                    .stream()
//                    .sorted(Comparator.comparing(Student::getGrade))
//                    .filter(student -> student.getGrade() >= 50.0 && student.getGrade() <= 100.0)
//                    .forEach(System.out::println);
//            System.out.println("\n");
//
//            System.out.println("=========  Task 3  =========\n");
//            System.out.println("The first student with grade in the range 50.0-100.0:");
//            System.out.println(studentList
//                    .stream()
//                    .filter(student -> student.getGrade() >= 50.0 && student.getGrade() <= 100.0)
//                    .findFirst()
//                    .get()
//            );
//            System.out.println("\n");
//
//            System.out.println("=========  Task 4  =========\n");
//            System.out.println("a.Students sorted by last name first and first name last in ascending order :");
//            studentList
//                    .stream()
//                    .sorted(Comparator.comparing(Student::getLastName)
//                            .thenComparing(Student::getFirstName))
//                    .forEach(System.out::println);
//            System.out.print("\n");
//            System.out.println("b.Students sorted by last name first and first name last in descending order :");
//            studentList
//                    .stream()
//                    .sorted(Comparator.comparing(Student::getLastName)
//                            .thenComparing(Student::getFirstName)
//                            .reversed())
//                    .forEach(System.out::println);
//            System.out.print("\n");
//
//            System.out.println("=========  Task 5  =========\n");
//            System.out.println("Unique student last names, sorted:");
//            studentList
//                    .stream()
//                    .map(Student::getLastName)
//                    .distinct()
//                    .sorted()
//                    .forEach(System.out::println);
//            System.out.println("\n");
            System.out.println("=========  Task 6  =========\n");
            System.out.println("Student full name sorted by last names then first name:");
            studentList
                    .stream()
                    .sorted(Comparator.comparing(Student::getLastName)
                            .thenComparing(Student::getFirstName))
                    .forEach(student->System.out.println(student.getFirstName()+ "   " + student.getLastName()));
            System.out.println("\n");

            System.out.println("=========  Task 7  =========\n");
            System.out.println("Students by department:\n");
            Map<String,List<Student>> stuArr=studentList
                    .stream()
                    .collect(Collectors.groupingBy(Student::getDepartment));
            stuArr.forEach((key,value)->{
                System.out.println(key);
                value.forEach(student->System.out.println("  "+student));
            });
            System.out.println("\n");

            System.out.println("=========  Task 8  =========\n");
            System.out.println("Count of Students by department:");
            studentList
                    .stream()
                    .collect(
                            Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                    .entrySet().forEach(entry->System.out.println(entry.getKey() + " has " + entry.getValue()+" Student(s)\n "));
            System.out.println("\n");

            System.out.println("=========  Task 9  =========\n");
            System.out.println("The sum of all Students’ grades:");
            Double sumGrade = studentList
                    .stream()
                    .mapToDouble(std -> std.getGrade()).sum();
            System.out.println(sumGrade);
            System.out.println("\n");

            System.out.println("=========  Task 10  =========\n");
            System.out.println("Average of all Students’ grades:");
            studentList
                    .stream()
                    .mapToDouble(std -> std.getGrade())
                    .average()
                    .ifPresent(avgGrade-> System.out.println(Math.round(avgGrade)));
            System.out.println("\n");


        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

}

