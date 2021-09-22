import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTimes = new int[input.length];
        int[] currentRobotTimeLeft = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("-");
            robots[i] = tokens[0];
            processTimes[i] = Integer.parseInt(tokens[1]);
            currentRobotTimeLeft[i] = 0;
        }

        int[] inputTime = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int time = inputTime[0] * 3600 + inputTime[1] * 60 + inputTime[2];

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        String product = "";
        while (!(product = scanner.nextLine()).equals("End")) {
            productsQueue.offer(product);
        }

        while (!productsQueue.isEmpty()) {
            for (int i = 0; i < robots.length; i++) {
                if (currentRobotTimeLeft[i] > 0) {
                    currentRobotTimeLeft[i]--;
                }
            }

            time++;

            String currentItem = productsQueue.poll();
            boolean isTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (currentRobotTimeLeft[i] == 0) {
                    System.out.printf("%s - %s [%s]%n", robots[i], currentItem, getTime(time));
                    currentRobotTimeLeft[i] = processTimes[i];
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                productsQueue.offer(currentItem);
            }
        }


    }

    private static String getTime(int time) {
        int hours = time / 3600 % 24;
        int mins = time / 60 % 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, mins, seconds);
    }
}