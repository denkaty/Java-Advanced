import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> stringSet = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] chemicalElements = scanner.nextLine().split("\\s+");
            stringSet.addAll(Arrays.asList(chemicalElements));
        }
        System.out.println(stringSet.toString().replaceAll("[\\[\\],]", ""));
    }
}
