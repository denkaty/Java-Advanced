import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class FindEvensOrOdds_06 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] tokens = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = tokens[0];
        int end = tokens[1];
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }
        String specifies = bufferedReader.readLine();
        Map<String, Predicate<Integer>> predicateMap = new HashMap<>();
        predicateMap.put("even", number -> number % 2 == 0);
        predicateMap.put("odd", number -> number % 2 != 0);

        numbers.stream()
                .filter(predicateMap.get(specifies))
                .forEach(number -> System.out.print(number + " "));
    }
}
