import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Lootbox_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queueFirstBox = new ArrayDeque<>();
        int[] firstBox = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int number : firstBox) {
            queueFirstBox.offer(number);
        }

        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();
        int[] secondBox = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int number : secondBox) {
            stackSecondBox.push(number);
        }

        int value = 0;
        while (!queueFirstBox.isEmpty() && !stackSecondBox.isEmpty()) {
            int sum = queueFirstBox.peek() + stackSecondBox.peek();

            if (sum % 2 == 0) {
                value += sum;
                queueFirstBox.poll();
                stackSecondBox.pop();
            } else {
                int removedItem = stackSecondBox.pop();
                queueFirstBox.offer(removedItem);
            }
        }

        if (queueFirstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (value >= 100) {
            System.out.println("Your loot was epic! Value: " + value);
        } else {
            System.out.println("Your loot was poor... Value: " + value);
        }

    }
}
