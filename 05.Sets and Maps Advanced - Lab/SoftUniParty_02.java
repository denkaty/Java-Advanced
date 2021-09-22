import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vips = new TreeSet<>();
        Set<String> regulars = new TreeSet<>();
        String input = "";
        while (!"PARTY".equals(input = scanner.nextLine())) {
            String guest = input;

            if (guest.length() == 8) {
                if (Character.isDigit(guest.charAt(0))) {
                    vips.add(guest);
                } else {
                    regulars.add(guest);
                }
            }
        }
        while (!"END".equals(input = scanner.nextLine())) {
            String guest = input;

            if (vips.contains(guest)) {
                vips.remove(guest);
            } else if (regulars.contains(guest)) {
                regulars.remove(guest);
            }
        }
        int guestNotCame = vips.size() + regulars.size();
        System.out.println(guestNotCame);
        vips.forEach(vip -> System.out.println(vip));
        regulars.forEach(regular -> System.out.println(regular));

    }
}
