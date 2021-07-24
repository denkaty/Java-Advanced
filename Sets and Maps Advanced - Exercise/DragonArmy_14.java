import java.util.*;

public class DragonArmy_14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, int[]>> dragonsStats = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            // {type} {name} {damage} {health} {armor}.

            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            int damage = getDamage(tokens);
            boolean damageIsDigit = Character.isDigit(tokens[2].charAt(0));

            int health = getHealth(tokens);
            boolean healthIsDigit = Character.isDigit(tokens[3].charAt(0));

            int armor = getArmor(tokens);
            boolean armorIsDigit = Character.isDigit(tokens[4].charAt(0));

            dragonsStats.putIfAbsent(type, new TreeMap<>());
            dragonsStats.get(type).putIfAbsent(name, new int[3]);

            int[] stats = dragonsStats.get(type).get(name);
            stats[0] = setStats0(damageIsDigit, damage);
            stats[1] = setStats1(healthIsDigit, health);
            stats[2] = setStats2(armorIsDigit, armor);

            dragonsStats.get(type).put(name, stats);

        }
        //{type} {name} {damage} {health} {armor}

        for (Map.Entry<String, Map<String, int[]>> type : dragonsStats.entrySet()) {
            Map<String, int[]> typeDragons = type.getValue();

            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;

            for (Map.Entry<String, int[]> dragon : typeDragons.entrySet()) {
                averageDamage += dragon.getValue()[0];
                averageHealth += dragon.getValue()[1];
                averageArmor += dragon.getValue()[2];
            }
            int size = typeDragons.size();
            averageDamage /= size;
            averageHealth /= size;
            averageArmor /= size;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), averageDamage, averageHealth, averageArmor);
            typeDragons.entrySet()
                    .forEach(dragon -> {
                        int[] tokens = dragon.getValue();
                        int damage = tokens[0];
                        int health = tokens[1];
                        int armor = tokens[2];

                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                                dragon.getKey(), damage, health, armor);
                    });

        }


    }


    private static int getDamage(String[] tokens) {
        int damage;
        boolean damageIsDigit = Character.isDigit(tokens[2].charAt(0));
        if (damageIsDigit) {
            damage = Integer.parseInt(tokens[2]);
        } else {
            damage = -1;
        }
        return damage;
    }

    private static int getHealth(String[] tokens) {
        int health;
        boolean healthIsDigit = Character.isDigit(tokens[3].charAt(0));
        if (healthIsDigit) {
            health = Integer.parseInt(tokens[3]);
        } else {
            health = -1;
        }
        return health;
    }

    private static int getArmor(String[] tokens) {
        int armor;
        boolean armorIsDigit = Character.isDigit(tokens[4].charAt(0));
        if (armorIsDigit) {
            armor = Integer.parseInt(tokens[4]);
        } else {
            armor = -1;
        }
        return armor;
    }

    private static int setStats0(boolean damageIsDigit, int damage) {
        int returnNumber;
        if (damageIsDigit) {
            returnNumber = damage;
        } else {
            returnNumber = 45;
        }
        return returnNumber;
    }

    private static int setStats1(boolean healthIsDigit, int health) {
        int returnNumber;
        if (healthIsDigit) {
            returnNumber = health;
        } else {
            returnNumber = 250;
        }
        return returnNumber;
    }

    private static int setStats2(boolean armorIsDigit, int armor) {
        int returnNumber;
        if (armorIsDigit) {
            returnNumber = armor;
        } else {
            returnNumber = 10;
        }
        return returnNumber;
    }
}