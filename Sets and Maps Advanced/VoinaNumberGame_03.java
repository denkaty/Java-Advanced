import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));


        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0) {
            int firstPlayerNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerNumber);

            int secondPlayerNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerNumber);


            if (firstPlayerNumber>secondPlayerNumber) {
                firstPlayerCards.addAll(Arrays.asList(firstPlayerNumber, secondPlayerNumber));
            } else if (firstPlayerNumber < secondPlayerNumber) {
                secondPlayerCards.addAll(Arrays.asList(firstPlayerNumber, secondPlayerNumber));
            }

            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        }else if (firstPlayerCards.size()<secondPlayerCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw");
        }

    }
}
