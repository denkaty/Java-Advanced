import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisibleNumber = Integer.parseInt(bufferedReader.readLine());

        Collections.reverse(numbers);

        BiConsumer<List<Integer>, Integer> biConsumer = (list, number) -> list.stream()
                .filter(currentNumber -> currentNumber % number != 0)
                .forEach(currentNumber -> System.out.print(currentNumber + " "));

        biConsumer.accept(numbers, divisibleNumber);
    }
}
