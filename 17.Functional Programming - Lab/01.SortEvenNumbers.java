import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(bufferedReader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .toArray();

        Consumer<int[]> consumer = arr -> System.out.println(Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));

        consumer.accept(numbers);
        Arrays.sort(numbers);
        consumer.accept(numbers);

    }

}
