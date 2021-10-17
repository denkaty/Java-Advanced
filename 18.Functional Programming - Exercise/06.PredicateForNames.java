import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;


public class PredicateForNames_06 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int maxLength = Integer.parseInt(bufferedReader.readLine());
        String[] names = bufferedReader.readLine().split("\\s+");

        Predicate<String> namePredicate = currentName -> currentName.length() <= maxLength;

        Arrays.stream(names)
                .filter(namePredicate)
                .forEach(name -> System.out.println(name));

    }
}
