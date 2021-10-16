import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = bufferedReader.readLine().split("\\s+");

        Consumer<String> consumer = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(consumer);
    }
}
