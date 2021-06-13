import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> openningSymbols = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                openningSymbols.push(i);
            } else if (currentChar == ')') {
                int startIndex = openningSymbols.pop();
                String substring = input.substring(startIndex, i +1);
                System.out.println(substring);
            }
        }
    }
}
