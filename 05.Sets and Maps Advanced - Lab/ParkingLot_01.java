import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set = new LinkedHashSet<>();
        String command = "";
        while (!"END".equals(command = scanner.nextLine())) {
            String[] tokens = command.split(", ");

            String direction = tokens[0];
            String carNumber = tokens[1];

            if (direction.equals("IN")) {
                set.add(carNumber);
            } else if (direction.equals("OUT")) {
                set.remove(carNumber);
            }
        }

        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            set.forEach(carNumber -> System.out.println(carNumber));
        }
    }
}
