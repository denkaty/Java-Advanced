import java.util.*;

public class LegendaryFarming_12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();
        boolean obtained = false;

        while (!obtained) {
            int quantity = scanner.nextInt();
            String material = scanner.next().toLowerCase();

            int totalQuantity = 0;
            if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                if (material.equalsIgnoreCase("shards")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    totalQuantity = keyMaterials.get(material);
                    if (totalQuantity >= 250) {
                        obtained = true;
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Shadowmourne obtained!");
                    }

                } else if (material.equalsIgnoreCase("fragments")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    totalQuantity = keyMaterials.get(material);
                    if (totalQuantity >= 250) {
                        obtained = true;
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Valanyr obtained!");
                    }
                } else {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    totalQuantity = keyMaterials.get(material);
                    if (totalQuantity >= 250) {
                        obtained = true;
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Dragonwrath obtained!");
                    }
                }

            } else {
                junkMaterials.putIfAbsent(material, 0);
                junkMaterials.put(material, junkMaterials.get(material) + quantity);
            }
        }
        keyMaterials.entrySet().stream().sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                .forEach(material -> {
                    System.out.printf("%s: %d%n", material.getKey(), material.getValue());
                });
        junkMaterials.entrySet().stream()
                .forEach(material -> {
                    System.out.printf("%s: %d%n", material.getKey(), material.getValue());
                });


    }
}
