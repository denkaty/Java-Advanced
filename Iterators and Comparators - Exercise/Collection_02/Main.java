import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        ListyIterator listyIterator = null;
        while (!"END".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    listyIterator = new ListyIterator(Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }

    }
}
