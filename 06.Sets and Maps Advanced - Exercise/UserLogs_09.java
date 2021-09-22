import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String input = "";
        while (!"end".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");

            String userTokens1 = tokens[2];
            String[] userTokens = userTokens1.split("=");
            String user = userTokens[1];

            String IPTokens1 = tokens[0];
            String[] IPTokens = IPTokens1.split("=");
            String IP = IPTokens[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> stringIntegerMap = users.get(user);
            stringIntegerMap.putIfAbsent(IP, 0);
            int counter = stringIntegerMap.get(IP);
            counter++;
            stringIntegerMap.put(IP, counter);

        }

        users.entrySet()
                .forEach(user -> {
                    System.out.printf("%s:%n", user.getKey());

                    int counter = 0;
                    Map<String, Integer> IPMap = user.getValue();
                    for (Map.Entry<String, Integer> IP : IPMap.entrySet()) {
                        counter++;

                        if (counter < IPMap.size()) {
                            System.out.printf("%s => %d, ", IP.getKey(), IP.getValue());
                        } else {
                            System.out.printf("%s => %d.%n", IP.getKey(), IP.getValue());
                        }
                    }
                });
    }
}
