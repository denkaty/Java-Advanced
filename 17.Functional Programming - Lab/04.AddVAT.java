import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT_04 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Prices with VAT:");

        UnaryOperator<Double> applyVAT = price -> price * 1.2;

        Arrays.stream(bufferedReader.readLine().split(", "))
                .mapToDouble(str -> applyVAT.apply(Double.parseDouble(str)))
                .forEach(itemPrice -> System.out.println(String.format("%.02f", itemPrice)));

    }
}
