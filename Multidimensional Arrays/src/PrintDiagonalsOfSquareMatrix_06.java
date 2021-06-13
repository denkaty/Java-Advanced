import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, size);

        printDiagonals(matrix, size);

    }

    private static int[] readArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }


    private static void printDiagonals(int[][] matrix, int size) {

        int row = 0;
        int col = 0;
        while (row < size && col < matrix[row].length) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();

        row = matrix.length - 1;
        col = 0;
        while (row >= 0 && col < matrix[row].length) {
            System.out.print(matrix[row--][col++] + " ");
        }

    }


}