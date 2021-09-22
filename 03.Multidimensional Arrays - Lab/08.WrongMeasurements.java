import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, rows);

        int[] tokens = readArray(scanner);
        int rowLocation = tokens[0];
        int colLocation = tokens[1];

        int mistakenValue = matrix[rowLocation][colLocation];

        int[][] finalMatrix = new int[rows][matrix[0].length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == mistakenValue) {
                    int sum = sumOfTheNearestElements(matrix, row, col, mistakenValue);
                    finalMatrix[row][col] = sum;
                } else {
                    finalMatrix[row][col] = currentNumber;
                }

            }
        }

        printMatrix(finalMatrix);
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return array;
    }


    private static int sumOfTheNearestElements(int[][] matrix, int row, int col, int mistakenValue) {
        int sumOfTheNearestElements = 0;

        int upSum = upSum(matrix, row, col, mistakenValue);
        int downSum = downSum(matrix, row, col, mistakenValue);
        int leftSum = leftSum(matrix, row, col, mistakenValue);
        int rightSum = rightSum(matrix, row, col, mistakenValue);

        sumOfTheNearestElements = upSum + downSum + leftSum + rightSum;

        return sumOfTheNearestElements;
    }

    private static int upSum(int[][] matrix, int row, int col, int mistakenValue) {
        if (row - 1 >= 0 && matrix[row - 1][col] != mistakenValue) {
            return matrix[row - 1][col];
        }
        return 0;
    }

    private static int downSum(int[][] matrix, int row, int col, int mistakenValue) {
        if (row + 1 < matrix.length && matrix[row + 1][col] != mistakenValue) {
            return matrix[row + 1][col];
        }
        return 0;
    }

    private static int leftSum(int[][] matrix, int row, int col, int mistakenValue) {
        if (col - 1 >= 0 && matrix[row][col - 1] != mistakenValue) {
            return matrix[row][col - 1];
        }
        return 0;
    }

    private static int rightSum(int[][] matrix, int row, int col, int mistakenValue) {
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != mistakenValue) {
            return matrix[row][col + 1];
        }
        return 0;
    }

    private static void printMatrix(int[][] finalMatrix) {
        for (int row = 0; row < finalMatrix.length; row++) {
            for (int col = 0; col < finalMatrix[row].length; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
