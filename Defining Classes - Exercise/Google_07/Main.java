package Google_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        String input = "";
        while (!"End".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            String command = tokens[1];

            Person person = new Person(name);

            boolean hasPerson = false;
            for (Person currentPerson : people) {
                if (currentPerson.getName().equals(name)) {
                    hasPerson = true;
                    person = currentPerson;
                    break;
                }
            }


            switch (command) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemons pokemon = new Pokemons(pokemonName, pokemonType);
                    List<Pokemons> pokemonList = person.getPokemonList();
                    pokemonList.add(pokemon);
                    person.setPokemonList(pokemonList);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parents parents = new Parents(parentName, parentBirthday);
                    List<Parents> parentsList = person.getParentsList();
                    parentsList.add(parents);
                    person.setParentsList(parentsList);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children children = new Children(childName, childBirthday);
                    List<Children> childrenList = person.getChildrenList();
                    childrenList.add(children);
                    person.setChildrenList(childrenList);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;

            }

            if (!hasPerson) {
                people.add(person);
            }
        }

        String targetName = bufferedReader.readLine();
        printTarget(targetName, people);


    }

    private static void printTarget(String targetName, List<Person> people) {
        for (Person person : people) {
            if (person.getName().equals(targetName)) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(person.getName()).append(System.lineSeparator());

                stringBuilder.append("Company:").append(System.lineSeparator());
                if (person.getCompany() != null) {
                    stringBuilder.append(person.getCompany().toString());
                    stringBuilder.append(System.lineSeparator());
                }

                stringBuilder.append("Car:").append(System.lineSeparator());
                if (person.getCar() != null) {
                    stringBuilder.append(person.getCar().getCarModel() + " " + person.getCar().getCarSpeed());
                    stringBuilder.append(System.lineSeparator());
                }

                stringBuilder.append("Pokemon:").append(System.lineSeparator());
                if (person.getPokemonList() != null) {
                    for (Pokemons pokemons : person.getPokemonList()) {
                        stringBuilder.append(pokemons.getPokemonName() + " " + pokemons.getPokemonType());
                        stringBuilder.append(System.lineSeparator());
                    }
                }

                stringBuilder.append("Parents:").append(System.lineSeparator());
                if (person.getParentsList() != null) {
                    for (Parents parents : person.getParentsList()) {
                        stringBuilder.append(parents.getParentName() + " " + parents.getParentBirthday());
                        stringBuilder.append(System.lineSeparator());
                    }
                }
                stringBuilder.append("Children:").append(System.lineSeparator());
                if (person.getChildrenList() != null) {
                    for (Children children : person.getChildrenList()) {
                        stringBuilder.append(children.getChildName() + " " + children.getChildBirthday());
                        stringBuilder.append(System.lineSeparator());
                    }
                }

                System.out.println(stringBuilder.toString());
            }
        }

    }
}
