import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsMap = new LinkedHashMap<>();
        String input = "";
        while (!"stop".equals(input = scanner.nextLine())) {
            String name = input;
            String email = scanner.nextLine();

            emailsMap.put(name, email);

            if (email.contains(".us") || email.contains(".uk") || email.contains(".com")) {
                emailsMap.remove(name);
            }
        }

        emailsMap.entrySet().stream().forEach(name -> System.out.printf("%s -> %s%n", name.getKey(), name.getValue()));

    }
}
