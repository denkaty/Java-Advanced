import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;

public class ListOfPredicates_09 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] divisibleNumbers = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<int[], Integer> biPredicate = (array, number) -> {
            for (int divisibleNumber : array) {
                if (number % divisibleNumber != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            if (biPredicate.test(divisibleNumbers, currentNumber)) {
                System.out.print(currentNumber + " ");
            }
        }

    }
}
