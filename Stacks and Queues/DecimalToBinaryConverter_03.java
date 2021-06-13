import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());
        int number = inputNumber;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (inputNumber != 0) {
            stack.push(inputNumber % 2);
            inputNumber /= 2;
        }

        if (number == 0) {
            System.out.println("0");
        } else {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
