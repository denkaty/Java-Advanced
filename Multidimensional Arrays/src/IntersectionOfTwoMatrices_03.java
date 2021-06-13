import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);

        char[][] thirdMatrix = intersectingElements(firstMatrix, secondMatrix, rows, cols);


        StringBuilder result = new StringBuilder();
        for (int row = 0; row < thirdMatrix.length; row++) {
            char[] arr = thirdMatrix[row];
            for (int col = 0; col < thirdMatrix[row].length; col++) {
                result.append(thirdMatrix[row][col]).append(" ");
            }
            result = new StringBuilder(result.toString().trim() + "\r\n");
        }
        System.out.println(result.toString());
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }
        }

        return matrix;
    }

    private static char[][] intersectingElements(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] thirdMatrix = new char[rows][cols];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                char firstMatrixChar = firstMatrix[row][col];
                char secondMatrixChar = secondMatrix[row][col];

                if (firstMatrixChar == secondMatrixChar) {
                    thirdMatrix[row][col] = firstMatrixChar;
                } else {
                    thirdMatrix[row][col] = '*';
                }
            }
        }
        return thirdMatrix;
    }
}
