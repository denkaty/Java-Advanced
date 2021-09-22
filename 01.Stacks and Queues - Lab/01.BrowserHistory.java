import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentURL = "";
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentURL = stack.pop();
                }
            } else {
                if (!currentURL.isEmpty()) {
                    stack.push(currentURL);
                }
                currentURL = input;
            }

            System.out.println(currentURL);
            input = scanner.nextLine();
        }

    }
}