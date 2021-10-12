import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers_02 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        Function<String, Integer> count = string -> {
            int[] numbers = Arrays.stream(string.split(", ")).mapToInt(Integer::parseInt).toArray();

            return numbers.length;
        };

        Function<String, Integer> sum = string -> {
            int[] numbers = Arrays.stream(string.split(", ")).mapToInt(Integer::parseInt).toArray();

            return Arrays.stream(numbers).sum();
        };

        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));

    }
}
