import java.util.Scanner;

public class MaximalSum_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int[] tokens = findTokens(matrix);

        print_maxSum_squareMatrix(matrix, tokens);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();


        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[] findTokens(int[][] matrix) {
        int[] maxSum_startingRow_StartingCol = new int[3];
        int maxSum = Integer.MIN_VALUE;
        int startingRow = -1;
        int startingCol = -1;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int sum = 0;
                for (int innerRow = row; innerRow < row + 3; innerRow++) {
                    for (int innerCol = col; innerCol < col + 3; innerCol++) {
                        int currentNumber = matrix[innerRow][innerCol];
                        sum += currentNumber;


                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    startingRow = row;
                    startingCol = col;
                }
            }
        }

        maxSum_startingRow_StartingCol[0] = maxSum;
        maxSum_startingRow_StartingCol[1] = startingRow;
        maxSum_startingRow_StartingCol[2] = startingCol;

        return maxSum_startingRow_StartingCol;
    }

    private static void print_maxSum_squareMatrix(int[][] matrix, int[] tokens) {
        int maxSum = tokens[0];
        int startingRow = tokens[1];
        int startingCol = tokens[2];

        System.out.println("Sum = " + maxSum);
        for (int row = startingRow; row < startingRow + 3; row++) {
            for (int col = startingCol; col < startingCol + 3; col++) {
                int currentNumber = matrix[row][col];
                System.out.print(currentNumber + " ");
            }
            System.out.println();
        }
    }
}
