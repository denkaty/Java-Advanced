import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phonebook = new LinkedHashMap<>();
        String input = "";
        while (!"search".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phonebook.put(name,phoneNumber);
        }

        while (!"stop".equals(input = scanner.nextLine())) {
            String name = input;

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            }else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
        }
    }
}
