import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> peoplesCards = new LinkedHashMap<>();
        String input = "";
        while (!"JOKER".equals(input = scanner.nextLine())) {

            if (input.charAt(0) != ':') {
                String[] tokens = input.split(": ");

                String name = tokens[0];
                List<String> cards = Arrays.stream(tokens[1].split(", ")).collect(Collectors.toList());

                peoplesCards.putIfAbsent(name, new LinkedHashSet<>());
                Set<String> cardsList = peoplesCards.get(name);
                cardsList.addAll(cards);


            }
        }

        peoplesCards.entrySet().forEach(person -> {
            System.out.printf("%s: %d%n", person.getKey(), getPower(person.getValue()));
        });
    }

    private static int getPower(Set<String> cards) {
        int finalPower = 0;
        int currentPower = 0;
        for (String card : cards) {
            char powerOfTheCard = card.charAt(0);

            char typeOfTheCard = card.charAt(1);
            if (typeOfTheCard == '0') {
                typeOfTheCard = card.charAt(2);
            }

            int powerMultiplyBy = 0;
            if (powerOfTheCard == '1' & card.charAt(1) == '0') {
                powerMultiplyBy = 10;
            } else if (Character.isDigit(powerOfTheCard)) {
                powerMultiplyBy = Integer.parseInt(String.valueOf(powerOfTheCard));
            } else if (powerOfTheCard == 'J') {
                powerMultiplyBy = 11;
            } else if (powerOfTheCard == 'Q') {
                powerMultiplyBy = 12;
            } else if (powerOfTheCard == 'K') {
                powerMultiplyBy = 13;
            } else if (powerOfTheCard == 'A') {
                powerMultiplyBy = 14;
            }

            int multiplyBy = 0;
            if (typeOfTheCard == 'S') {
                multiplyBy = 4;
            } else if (typeOfTheCard == 'H') {
                multiplyBy = 3;
            } else if (typeOfTheCard == 'D') {
                multiplyBy = 2;
            } else if (typeOfTheCard == 'C') {
                multiplyBy = 1;
            }

            currentPower = powerMultiplyBy * multiplyBy;
            finalPower += currentPower;
        }

        return finalPower;
    }
}