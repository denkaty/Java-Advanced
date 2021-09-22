import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = n; i < n + m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        Set<Integer> thirdSet = new LinkedHashSet<>();
        for (Integer number : firstSet) {
            if (secondSet.contains(number)) {
                thirdSet.add(number);
            }
        }

        System.out.println(thirdSet.toString().replaceAll("[\\[\\],]", ""));

    }
}
