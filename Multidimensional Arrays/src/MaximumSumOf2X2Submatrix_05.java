import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = readArray(scanner);
        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = readMatrix(scanner, rows, cols);

        String result = output(matrix, rows, cols);
        System.out.println(result);

    }

    private static int[] readArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
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


    private static String output(int[][] matrix, int rows, int cols) {
        int maxSum = Integer.MIN_VALUE;
        int returnRow = 0;
        int returnCol = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    returnRow = row;
                    returnCol = col;
                }
            }
        }

        String result = matrix[returnRow][returnCol] + " " + matrix[returnRow][returnCol + 1] + System.lineSeparator()
                + matrix[returnRow + 1][returnCol] + " " + matrix[returnRow + 1][returnCol + 1] + System.lineSeparator()
                + maxSum;

        return result;
    }
}