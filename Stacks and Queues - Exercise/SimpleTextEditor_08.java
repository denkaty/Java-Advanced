import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String text = "";
        stack.push(text);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfOperations; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            switch (command) {

                case "1":
                    String string = tokens[1];
                    StringBuilder stringBuilder = new StringBuilder(text);
                    stringBuilder.append(string);
                    text = String.valueOf(stringBuilder);

                    stack.push(text);
                    break;

                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    StringBuilder stringBuilder1 = new StringBuilder(text);
                    text = String.valueOf(stringBuilder1.delete(stringBuilder1.length() - count, stringBuilder1.length()));

                    stack.push(text);

                    break;

                case "3":
                    int characterToPrint = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(characterToPrint-1));
                    break;
                case "4":
                    stack.pop();
                    text = stack.peek();
            }
        }
    }
}

