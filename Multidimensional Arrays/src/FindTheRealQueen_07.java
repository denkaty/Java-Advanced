import java.util.Scanner;

public class FindTheRealQueen_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);

        boolean flag = false;
        for (int row = 0; row < 8; row++) {
            if (flag) {
                break;
            }
            for (int col = 0; col < 8; col++) {
                String element = matrix[row][col];

                if (element.equals("q")) {
                    boolean up = checkUp(matrix, row, col);
                    boolean down = checkDown(matrix, row, col);
                    boolean wholeRow = checkWholeRow(matrix, row, col);
                    boolean secondDiagonalUp = checkSecondDiagonalUp(matrix, row, col);
                    boolean secondDiagonalDown = checkSecondDiagonalDown(matrix, row, col);
                    boolean firstDiagonalUp = checkFirstDiagonalUp(matrix, row, col);
                    boolean firstDiagonalDown = checkFirstDiagonalDown(matrix, row, col);


                    if (up && down && wholeRow && firstDiagonalUp && firstDiagonalDown && secondDiagonalDown && secondDiagonalUp) {
                        System.out.println(row + " " + col);
                        flag = true;
                        break;
                    }
                }
            }
        }
    }

    private static String[][] readMatrix(Scanner scanner) {
        String[][] matrix = new String[8][8];

        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }

    private static boolean checkUp(String[][] matrix, int row, int col) {

        while (--row >= 0) {
            String element = matrix[row][col];

            if (element.equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDown(String[][] matrix, int row, int col) {
        while (++row < 8) {
            String element = matrix[row][col];

            if (element.equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWholeRow(String[][] matrix, int row, int col) {
        int i = 0;
        while (row == row && i < 8) {
            String element = matrix[row][i];

            if (i != col) {
                if (element.equals("q")) {
                    return false;
                }
            }

            i++;
        }
        return true;
    }

    private static boolean checkSecondDiagonalUp(String[][] matrix, int row, int col) {
        while (--row >= 0 && ++col < 8) {
            String element = matrix[row][col];

            if (element.equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSecondDiagonalDown(String[][] matrix, int row, int col) {
        while (++row < 8 && --col >= 0) {
            String element = matrix[row][col];

            if (element.equals("q")) {
                return false;
            }
        }
        return true;
    }


    private static boolean checkFirstDiagonalUp(String[][] matrix, int row, int col) {
        while (--row >= 0 && --col >= 0) {
            String element = matrix[row][col];
            if (element.equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkFirstDiagonalDown(String[][] matrix, int row, int col) {
        while (++row < 8 && ++col < 8) {
            String element = matrix[row][col];
            if (element.equals("q")) {
                return false;
            }
        }
        return true;
    }
}