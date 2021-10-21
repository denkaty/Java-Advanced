import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Bombs_01 {
    //15:20 - 21.10.2021
    //15:50 - 21.10.2021

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int daturaBombsCounter = 0;
        int cherryBombsCounter = 0;
        int smokeDecoyBombsCounter = 0;
        ArrayDeque<Integer> queueBombEffects = new ArrayDeque<>();
        queueBombEffects = readQueue(bufferedReader.readLine());

        ArrayDeque<Integer> stackBombCasings = new ArrayDeque<>();
        stackBombCasings = readStack(bufferedReader.readLine());

        boolean hasField = false;
        while (!queueBombEffects.isEmpty() && !stackBombCasings.isEmpty() && !hasField) {
            int sumOfValues = queueBombEffects.peek() + stackBombCasings.peek();

            if (sumOfValues == 40 || sumOfValues == 60 || sumOfValues == 120) {
                if (sumOfValues == 40) {
                    daturaBombsCounter++;
                } else if (sumOfValues == 60) {
                    cherryBombsCounter++;
                } else {
                    smokeDecoyBombsCounter++;
                }

                if (daturaBombsCounter >= 3 && cherryBombsCounter >= 3 && smokeDecoyBombsCounter >= 3) {
                    hasField = true;
                }

                queueBombEffects.poll();
                stackBombCasings.pop();
            } else {
                int popped = stackBombCasings.pop();
                stackBombCasings.push(popped - 5);
            }

        }

        if (hasField) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queueBombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            String remainingBombEffectsToString = queueBombEffects.toString().replaceAll("[\\[\\]]", "");
            System.out.println(remainingBombEffectsToString);

        }

        if (stackBombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            String remainingBombCasingsToString = stackBombCasings.toString().replaceAll("[\\[\\]]", "");
            System.out.println(remainingBombCasingsToString);
        }

        System.out.println("Cherry Bombs: " + cherryBombsCounter);
        System.out.println("Datura Bombs: " + daturaBombsCounter);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombsCounter);

    }

    private static ArrayDeque<Integer> readQueue(String input) {
        int[] queueNumbers = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int queueNumber : queueNumbers) {
            queue.offer(queueNumber);
        }
        return queue;
    }

    private static ArrayDeque<Integer> readStack(String input) {
        int[] stackNumbers = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int stackNumber : stackNumbers) {
            stack.push(stackNumber);
        }
        return stack;
    }
}
