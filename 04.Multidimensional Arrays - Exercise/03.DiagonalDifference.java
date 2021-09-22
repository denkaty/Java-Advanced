import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, size);

        int sumDifference = calculateSumDifference(matrix, size);
        System.out.println(sumDifference);
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return array;
    }

    private static int calculateSumDifference(int[][] matrix, int size) {
        int leftDiagonal = calculateLeftDiagonal(matrix, size);
        int rightDiagonal = calculateRightDiagonal(matrix, size);

        int diagonalDifference = Math.abs(leftDiagonal - rightDiagonal);
        return diagonalDifference;
    }

    private static int calculateLeftDiagonal(int[][] matrix, int size) {
        int row = 0;
        int col = 0;
        int sum = 0;
        while (row < size && col < size) {
            sum += matrix[row][col];
            row++;
            col++;
        }
        return sum;
    }

    private static int calculateRightDiagonal(int[][] matrix, int size) {
        int row = size - 1;
        int col = 0;
        int sum = 0;
        while (row >= 0 && col < size) {
            sum += matrix[row][col];
            row--;
            col++;
        }
        return sum;
    }
}
