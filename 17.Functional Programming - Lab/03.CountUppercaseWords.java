import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String text = bufferedReader.readLine();

        Predicate<String> predicate = string -> Character.isUpperCase(string.charAt(0));

        StringBuilder output = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(0);
        Consumer<String> appendToOutput = string -> {
          counter.incrementAndGet();

            output.append(string)
                    .append(System.lineSeparator());
        };
        Arrays.stream(text.split("\\s+"))
                .filter(predicate)
                .forEach(appendToOutput);

        System.out.println(counter.get());
        System.out.println(output.toString());
    }
}
