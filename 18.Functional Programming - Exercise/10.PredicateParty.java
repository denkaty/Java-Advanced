import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = Arrays.stream(bufferedReader.readLine().split("\\s+")).collect(Collectors.toList());

        String input = "";
        while (!"Party!".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String givenCriteria = tokens[1];

            BiPredicate<String, String> predicate = null;
            switch (givenCriteria) {
                case "StartsWith":
                    predicate = (guest, letter) -> guest.startsWith(letter);
                    break;

                case "EndsWith":
                    predicate = (guest, letter) -> guest.endsWith(letter);
                    break;

                case "Length":
                    predicate = (guest, lengthString) -> {
                        int length = Integer.parseInt(lengthString);
                        return guest.length() == length;
                    };
                    break;
            }

            if (command.equals("Remove")) {
                for (int i = 0; i < guests.size(); i++) {
                    if (predicate.test(guests.get(i), tokens[2])) {
                        guests.remove(i);
                        i--;
                    }
                }

            } else if (command.equals("Double")) {
                int startSize = guests.size();
                for (int i = 0; i < startSize; i++) {
                    if (predicate.test(guests.get(i), tokens[2])) {
                        guests.add(guests.get(i));
                    }
                }
            }


        }
        if (!guests.isEmpty()) {
            guests.sort((guest1, guest2) -> guest1.compareTo(guest2));

            System.out.println(String.format("%s are going to the party!", guests.toString().replaceAll("[\\[\\]]", "")));
        } else {

            System.out.println("Nobody is going to the party!");
        }
    }
}