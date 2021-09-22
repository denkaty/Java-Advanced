import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> openningSymbols = new ArrayDeque<>();
        boolean balanced = true;

        if (input.charAt(0) == '}' || input.charAt(0) == ')' || input.charAt(0) == ']') {
            System.out.println("NO");
        } else if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                    openningSymbols.push(String.valueOf(currentChar));
                    balanced = false;
                } else if (currentChar == '}' || currentChar == ')' || currentChar == ']') {
                    char previousChar = openningSymbols.pop().charAt(0);

                    if (previousChar == '{' && currentChar != '}' || previousChar == '(' && currentChar != ')' || previousChar == '[' && currentChar != ']') {
                        balanced = false;
                        break;
                    } else {
                        balanced = true;
                    }

                }
            }
            if (balanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
