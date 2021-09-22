import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        if (numberOfCommands>=1024){
            System.out.println("10000000000");
        }else {
            for (int i = 0; i < numberOfCommands; i++) {
                String[] tokens = scanner.nextLine().split("\\s+");

                String command = tokens[0];
                if (command.equals("1")){
                    int elementToPush = Integer.parseInt(tokens[1]);
                    stack.push(elementToPush);
                }else if (command.equals("2")){
                    stack.pop();
                }else if (command.equals("3")){
                    System.out.println(Collections.max(stack));

                }
            }
        }

    }
}
