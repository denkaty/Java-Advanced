import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementsToPush = firstInput[0];
        int elementsToPop = firstInput[1];
        int checkIfPresented = firstInput[2];

        int[] secondInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(secondInput[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }
        if (stack.contains(checkIfPresented)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
