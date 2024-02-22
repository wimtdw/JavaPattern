package lab1;


import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Ivan", "Group A"),
                new Student("Petr", "Group B"),
                new Student("Alexei", "Group A"),
                new Student("Andrey", "Group B"),
                new Student("Nikita", "Group C"),
                new Student("Nikolai", "Group C")
        };
        GroupByFunction groupByFunction = new GroupByFunction();
        Map<String, List<Student>> groupedStudents = groupByFunction.apply(students);
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            String group = entry.getKey();
            List<Student> studentList = entry.getValue();
            System.out.println("Group: " + group);
            for (Student student : studentList) {
                System.out.println("Name: " + student.getName());
            }
            System.out.println();
        }
    }
}
