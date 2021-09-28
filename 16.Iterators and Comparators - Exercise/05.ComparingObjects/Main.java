package ComparingObjects_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();

        String input = "";
        while (!"END".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            int years = Integer.parseInt(tokens[1]);
            String city = tokens[2];

            Person person = new Person(name, years, city);
            personList.add(person);
        }

        int equalCountPeople = 0;
        int notEqualCountPeople = 0;
        int personIndex = Integer.parseInt(bufferedReader.readLine()) - 1;
        Person target = personList.get(personIndex);
        for (Person person : personList) {
            if (person.compareTo(target) == 0) {
                equalCountPeople++;
            } else {
                notEqualCountPeople++;
            }
        }

        if (equalCountPeople - 1 == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", equalCountPeople, notEqualCountPeople, personList.size()));
        }

    }
}
