import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();
        for (double currentNumber : input) {
            if (!numbersMap.containsKey(currentNumber)) {
                numbersMap.put(currentNumber, 1);
            } else {
                int currentCounter = numbersMap.get(currentNumber);
                currentCounter++;
                numbersMap.put(currentNumber, currentCounter);
            }
        }

        numbersMap.entrySet()
                .forEach(number -> {
                    System.out.println(String.format("%.01f -> %d", number.getKey(), number.getValue()));
                });


    }
}
