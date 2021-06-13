import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = readArray(scanner);

        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = readMatrix(scanner, rows, cols);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int sum = calculateSum(matrix, rows, cols);
        System.out.println(sum);
    }

    private static int[] readArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\,\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }

    private static int calculateSum(int[][] matrix, int rows, int cols) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int number = matrix[row][col];
                sum += number;
            }
        }
        return sum;
    }
}