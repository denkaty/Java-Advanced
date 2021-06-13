import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = readArr(scanner, "\\s+");
        int rows = tokens[0];
        int cols = tokens[1];
        int[][] firstMatrix = readMatrix(scanner, rows, cols);

        tokens = readArr(scanner, "\\s+");
        rows = tokens[0];
        cols = tokens[1];
        int[][] secondMatrix = readMatrix(scanner, rows, cols);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);
        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static int[] readArr(Scanner scanner, String pattern) {
        int[] tokens = Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();

        return tokens;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = readArr(scanner, "\\s+");
            matrix[row] = arr;
        }
        return matrix;
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        } else {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];

                if (firstArr.length != secondArr.length) {
                    return false;
                } else {
                    for (int col = 0; col < firstArr.length; col++) {
                        int firstElement = firstArr[col];
                        int secondElement = secondArr[col];

                        if (firstElement != secondElement) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}