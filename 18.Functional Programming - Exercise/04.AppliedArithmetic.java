import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /*

        "add" -> adds 1;
        "multiply" -> multiplies by 2;
        "subtract" -> subtracts 1;
        "print" -> prints all numbers on a new line.

        */


        int[] numbers = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addFunction = intArr -> Arrays.stream(intArr).map(number -> number + 1).toArray();
        Function<int[], int[]> multiplyFunction = intArr -> Arrays.stream(intArr).map(number -> number * 2).toArray();
        Function<int[], int[]> subtractFunction = intArr -> Arrays.stream(intArr).map(number -> number - 1).toArray();
        Consumer<int[]> printConsumer = intArr -> Arrays.stream(intArr).forEach(number -> System.out.print(number + " "));
        String command = "";
        while (!"end".equals(command = bufferedReader.readLine())) {

            switch (command) {
                case "add":
                    numbers = addFunction.apply(numbers);
                    break;

                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;

                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;

                case "print":
                    printConsumer.accept(numbers);
                    System.out.println();
                    break;
            }

        }

    }
}
