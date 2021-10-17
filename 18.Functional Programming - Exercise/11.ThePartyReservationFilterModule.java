import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = Arrays.stream(bufferedReader.readLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String input = "";
        while (!"Print".equals(input = bufferedReader.readLine())) {

            String[] tokens = input.split(";");
            String command = tokens[0];

            Predicate<String> predicate = null;
            String givenCriteria = tokens[1];
            if (command.equals("Add filter")) {
                switch (givenCriteria) {
                    case "Starts with":
                        predicate = guest -> guest.startsWith(tokens[2]);
                        break;

                    case "Ends with":
                        predicate = guest -> guest.endsWith(tokens[2]);
                        break;

                    case "Length":
                        predicate = guest -> guest.length() == Integer.parseInt(tokens[2]);
                        break;

                    case "Contains":
                        predicate = guest -> guest.contains(tokens[2]);
                        break;
                }
                String key = tokens[1] + " " + tokens[2];
                predicates.putIfAbsent(key, predicate);

            } else {
                String key = tokens[1] + " " + tokens[2];
                predicates.remove(key);
            }
        }
        for (String guest : guests) {
            boolean flag = true;
            for (String predicateName : predicates.keySet()) {
                if (predicates.get(predicateName).test(guest)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print(guest + " ");
            }
        }
    }
}
