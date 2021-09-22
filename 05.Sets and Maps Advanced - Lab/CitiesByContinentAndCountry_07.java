import java.util.*;

public class CitiesByContinentAndCountry_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentsMap.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> stringListMap = continentsMap.get(continent);
            stringListMap.putIfAbsent(country, new ArrayList<>());
            stringListMap.get(country).add(city);
        }
        continentsMap.entrySet()
                .stream()
                .forEach(continent -> {
                    System.out.printf("%s:%n", continent.getKey());
                    continent.getValue().forEach((country, city) -> {
                        System.out.printf("%s -> %s%n", country, city.toString().replaceAll("[\\[\\]]", ""));
                    });
                });
    }
}