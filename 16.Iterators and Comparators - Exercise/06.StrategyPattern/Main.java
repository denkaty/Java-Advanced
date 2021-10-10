package StrategyPattern_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> byName = new TreeSet<>(new CompareByName());
        Set<Person> byAge = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            byName.add(person);
            byAge.add(person);
        }

        byName.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
        byAge.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

    }
}
