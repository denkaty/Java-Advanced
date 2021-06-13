import java.util.ArrayDeque;
        import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentURL = "";

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    queue.addFirst(currentURL);
                    currentURL = stack.pop();
                }
            } else if (input.equals("forward")) {
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    stack.push(currentURL);
                    currentURL = queue.poll();
                }
            } else {
                queue.clear();

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
