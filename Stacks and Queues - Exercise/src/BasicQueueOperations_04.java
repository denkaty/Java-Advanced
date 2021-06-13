import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {

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

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            queue.offer(secondInput[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(checkIfPresented)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }

    }
}
