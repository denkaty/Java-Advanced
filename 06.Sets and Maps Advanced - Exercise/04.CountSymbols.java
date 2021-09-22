import java.util.*;

public class CountSymbols_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> characterIntegerMap = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            characterIntegerMap.putIfAbsent(currentChar, 0);
            int counts = characterIntegerMap.get(currentChar);
            counts++;
            characterIntegerMap.put(currentChar, counts);

        }
        characterIntegerMap.entrySet().stream()
                .forEach(character -> System.out.printf("%c: %d time/s%n", character.getKey(), character.getValue()));
    }
}
