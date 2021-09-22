import java.util.Scanner;

public class PositionsOf_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = readMatrix(scanner, rows, cols);

        int number = scanner.nextInt();

        String result = "";
        result = checkNumbers(matrix, number, result);

        if (result.equals("")){
            System.out.println("not found");
        }else {
            System.out.println(result);
        }

    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static String checkNumbers(int[][] matrix, int number, String result) {
        StringBuilder resultBuilder = new StringBuilder(result);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == number) {
                    resultBuilder.append(row).append(" ").append(col).append(System.lineSeparator());
                }
            }
        }
        result = resultBuilder.toString();
        return result;
    }
}