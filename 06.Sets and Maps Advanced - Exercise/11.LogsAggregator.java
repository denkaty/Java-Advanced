import java.util.*;

public class LogsAggregator_11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usersDuration = new TreeMap<>();
        Map<String, Set<String>> usersIP = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String IP = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            usersDuration.putIfAbsent(user, 0);
            int currentDuration = usersDuration.get(user);
            currentDuration += duration;
            usersDuration.put(user, currentDuration);

            usersIP.putIfAbsent(user, new TreeSet<>());
            Set<String> userIPList = usersIP.get(user);
            userIPList.add(IP);
        }
        usersDuration.entrySet()
                .forEach(user -> {
                    System.out.printf("%s: %d %s%n", user.getKey(), user.getValue(), usersIP.get(user.getKey()).toString());
                });
    }

}
