import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();
        int counter = 0;
        String input = "";
        String material = "";
        while (!"stop".equals(input = scanner.nextLine())) {
            counter++;

            if (counter % 2 != 0) {
                material = input;
                resources.putIfAbsent(material, 0);
            } else {
                int quantity = resources.get(material);
                quantity += Integer.parseInt(input);
                resources.put(material, quantity);
            }
        }

        resources.entrySet().stream()
                .forEach(resource -> System.out.printf("%s -> %d%n", resource.getKey(), resource.getValue()));
    }
}
