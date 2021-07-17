import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> foodShops = new TreeMap<>();

        String input = "";
        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!foodShops.containsKey(shop)) {
                foodShops.put(shop, new LinkedHashMap<>());
            }
            Map<String, Double> stringDoubleMap = foodShops.get(shop);
            stringDoubleMap.put(product, price);
            foodShops.put(shop, stringDoubleMap);
        }

        foodShops.entrySet()
                .stream()
                .forEach(shop -> {
                    System.out.printf("%s->%n", shop.getKey());
                    shop.getValue().forEach((product, price) -> {
                        System.out.printf("Product: %s, Price: %.1f%n", product, price);
                    });
                });
    }
}
