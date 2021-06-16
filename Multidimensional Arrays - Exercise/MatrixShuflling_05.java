import java.util.Scanner;

public class MatrixShuflling_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = readMatrix(scanner, rows, cols);

        String command = "";
        while (!"END".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");

            boolean correctCommand = checkCommand(tokens, rows, cols);
            if (correctCommand) {
                matrix = swapPositions(matrix, tokens);

                printNewMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {


        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }

    private static boolean checkCommand(String[] tokens, int rows, int cols) {
        String command = tokens[0];


        if (!command.equals("swap")) {
            return false;
        } else if (tokens.length != 5) {
            return false;
        } else if (!Character.isDigit(tokens[1].charAt(0)) || !Character.isDigit(tokens[2].charAt(0)) || !Character.isDigit(tokens[3].charAt(0)) || !Character.isDigit(tokens[4].charAt(0))) {
            return false;
        }
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        if (row1 >= rows || col1 >= cols || row2 >= rows || col2 >= cols) {
            return false;
        }

        return true;
    }

    private static String[][] swapPositions(String[][] matrix, String[] tokens) {
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        String oldText = matrix[row1][col1];
        String newText = matrix[row2][col2];

        matrix[row1][col1] = newText;
        matrix[row2][col2] = oldText;

        return matrix;


    }

    private static void printNewMatrix(String[][] newMatrix) {
        for (String[] array : newMatrix) {
            for (String currentString : array) {
                System.out.print(currentString + " ");
            }
            System.out.println();

        }

    }
}