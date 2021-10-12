import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge_05 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = bufferedReader.readLine().split(", ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        String ageCondition = bufferedReader.readLine();
        int age = Integer.parseInt(bufferedReader.readLine());

        Map<String, Predicate<Person>> predicateMap = new HashMap<>();
        predicateMap.put("younger", person -> person.age <= age);
        predicateMap.put("older", person -> person.age >= age);

        String format = bufferedReader.readLine();

        Map<String, Consumer<Person>> consumerMap = new HashMap<>();
        consumerMap.put("name", person -> System.out.println(person.name));
        consumerMap.put("age", person -> System.out.println(person.age));
        consumerMap.put("name age", person -> System.out.println(person.name + " - " + person.age));

        people.stream()
                .filter(predicateMap.get(ageCondition))
                .forEach(consumerMap.get(format));

    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
