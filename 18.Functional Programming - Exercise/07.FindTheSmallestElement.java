import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementFunction = integersList -> {
            int min = integersList.stream().min(Integer::compareTo).get();
            int indexOfMin = integersList.lastIndexOf(min);

            return indexOfMin;
        };

        int index = minElementFunction.apply(numbers);
        System.out.println(index);
    }
}
