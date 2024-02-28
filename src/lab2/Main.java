package lab2;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human(25, "Ivan", "Ivanov", LocalDate.of(2003, 5, 15), 70),
                new Human(35, "Petr", "Petrov", LocalDate.of(2004, 10, 23), 65),
                new Human(45, "Sergey", "Sergeev", LocalDate.of(1944, 3, 8), 80),
                new Human(55, "Oleg", "Olegov", LocalDate.of(1966, 8, 31), 60)
        );
        System.out.println("Исходный список людей:");
        humans.forEach(System.out::println);
        System.out.println("\nСписок людей, отсортированный по дате рождения:");
        List<Human> sortedByBirthDate = humans.stream()
                .sorted((h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()))
                .collect(Collectors.toList());
        sortedByBirthDate.forEach(System.out::println);
        System.out.println("\nСписок людей, возраст которых меньше 50 лет:");
        List<Human> ageLessThan50 = sortedByBirthDate.stream()
                .filter(h -> h.getAge() < 50)
                .collect(Collectors.toList());
        ageLessThan50.forEach(System.out::println);
        System.out.println("\nСписок людей, отсортированный по весу:");
        List<Human> sortedByWeight = ageLessThan50.stream()
                .sorted((h1, h2) -> h1.getWeight() - h2.getWeight())
                .collect(Collectors.toList());
        sortedByWeight.forEach(System.out::println);
        System.out.println("\nКонкатенация всех имен в одну строку:");
        String concatenatedNames = sortedByWeight.stream()
                .map(human -> human.getFirstName())
                .collect(Collectors.joining(" "));
        System.out.println(concatenatedNames);
    }
}



