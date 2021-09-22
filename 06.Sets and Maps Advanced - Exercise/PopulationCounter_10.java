import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PopulationCounter_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countriesAndCities = new LinkedHashMap<>();
        Map<String, Long> countriesOnly = new LinkedHashMap<>();
        String input = "";
        while (!"report".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\|");

            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt(tokens[2]);


            countriesAndCities.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> citiesMap = countriesAndCities.get(country);
            citiesMap.putIfAbsent(city, 0L);
            long cityPopulation = citiesMap.get(city);
            cityPopulation += population;
            citiesMap.put(city, cityPopulation);

            countriesOnly.putIfAbsent(country, 0L);
            long currentPopulation = countriesOnly.get(country);
            currentPopulation += population;
            countriesOnly.put(country, currentPopulation);
        }

        countriesAndCities.entrySet().stream()
                .sorted((left, right) ->
                        countriesOnly.get(right.getKey()).compareTo(countriesOnly.get(left.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), countriesOnly.get(country.getKey()));
                    country.getValue().entrySet().stream()
                            .sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }
}