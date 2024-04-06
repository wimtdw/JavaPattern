package javalabs.lab13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoPrinter implements CommandLineRunner {

    @Value("${student.name}")
    private String studentName;

    @Value("${student.last_name}")
    private String studentLastName;

    @Value("${student.group}")
    private String studentGroup;

    public void run(String... args) throws Exception {
        System.out.println("Имя студента: " + studentName);
        System.out.println("Фамилия студента: " + studentLastName);
        System.out.println("Группа студента: " + studentGroup);
    }
}