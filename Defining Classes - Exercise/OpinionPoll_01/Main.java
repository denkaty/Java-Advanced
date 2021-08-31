package OpinionPoll_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }

        personList.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((left, right) -> left.getName().compareTo(right.getName()))
                .forEach(person -> System.out.println(String.format("%s - %d",
                        person.getName(), person.getAge())));
    }
}
