import java.util.Scanner;

public class RecursiveFibonacci_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if (n<=2){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
}
