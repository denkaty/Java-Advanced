import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt_02 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sizeOfMatrix = Integer.parseInt(bufferedReader.readLine());
        int countOfCommands = Integer.parseInt(bufferedReader.readLine());

        int playerRow = 0;
        int playerCow = 0;
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = bufferedReader.readLine().toCharArray();
        }

        boolean playerHasWon = false;
        int[] currentPosition = getCurrentPosition(matrix);
        int[] finishPosition = getFinishPosition(matrix);
        int finishRow = finishPosition[0];
        int finishCow = finishPosition[1];
        while (countOfCommands-- > 0 && !playerHasWon) {
            String command = bufferedReader.readLine();
            playerRow = currentPosition[0];
            playerCow = currentPosition[1];

            if (command.equals("up")) {
                moveUp(matrix, playerRow, playerCow);
            } else if (command.equals("down")) {
                moveDown(matrix, playerRow, playerCow);
            } else if (command.equals("left")) {
                moveLeft(matrix, playerRow, playerCow);
            } else if (command.equals("right")) {
                moveRight(matrix, playerRow, playerCow);
            }
            currentPosition = getCurrentPosition(matrix);
            playerRow = currentPosition[0];
            playerCow = currentPosition[1];
            playerHasWon = playerRow == finishRow && playerCow == finishCow;
        }

        if (playerHasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow]);
            }
            System.out.println();
        }
    }


    private static int[] getCurrentPosition(char[][] matrix) {
        int[] currentPosition = {0, 0};
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                char currentChar = matrix[row][cow];

                if (currentChar == 'f') {
                    currentPosition[0] = row;
                    currentPosition[1] = cow;
                }
            }
        }
        return currentPosition;
    }

    private static int[] getFinishPosition(char[][] matrix) {
        int[] finishPosition = {0, 0};
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                char currentChar = matrix[row][cow];

                if (currentChar == 'F') {
                    finishPosition[0] = row;
                    finishPosition[1] = cow;
                }
            }
        }
        return finishPosition;
    }

    private static void moveUp(char[][] matrix, int playerRow, int playerCow) {
        boolean flag = false;
        int beforeRecursiveRow = -1;
        int beforeRecursiveCow = -1;
        int prevRow = playerRow;
        if (playerRow - 1 == -1) {
            playerRow = matrix.length;
        }
        if (matrix[playerRow - 1][playerCow] != 'T') {
            if (playerRow == matrix.length) {
                prevRow = 0;
            }
            matrix[prevRow][playerCow] = '-';
            playerRow--;
            if (matrix[playerRow][playerCow] == 'B') {
                beforeRecursiveRow = playerRow;
                beforeRecursiveCow = playerCow;
                moveUp(matrix, playerRow, playerCow);
                flag = true;
                matrix[beforeRecursiveRow][beforeRecursiveCow] = 'B';


            }
            if (!flag) {
                matrix[playerRow][playerCow] = 'f';
            }
        } else {
            playerRow = prevRow;
        }
    }


    private static void moveDown(char[][] matrix, int playerRow, int playerCow) {
        boolean flag = false;
        int beforeRecursiveRow = -1;
        int beforeRecursiveCow = -1;
        int prevRow = playerRow;

        if (playerRow + 1 == matrix.length) {
            playerRow = -1;
        }
        if (matrix[playerRow + 1][playerCow] != 'T') {
            if (playerRow == -1) {
                prevRow = matrix.length - 1;
            }
            matrix[prevRow][playerCow] = '-';
            playerRow++;
            if (matrix[playerRow][playerCow] == 'B') {
                beforeRecursiveRow = playerRow;
                beforeRecursiveCow = playerCow;
                moveDown(matrix, playerRow, playerCow);
                flag = true;
                matrix[beforeRecursiveRow][beforeRecursiveCow] = 'B';


            }
            if (!flag) {
                matrix[playerRow][playerCow] = 'f';
            }
        } else {
            playerRow = prevRow;
        }
    }

    private static void moveRight(char[][] matrix, int playerRow, int playerCow) {
        boolean flag = false;
        int beforeRecursiveRow = -1;
        int beforeRecursiveCow = -1;
        int prevCow = playerCow;
        if (playerCow + 1 == matrix[playerRow].length) {
            playerCow = -1;
        }

        if (matrix[playerRow][playerCow + 1] != 'T') {
            if (playerCow == -1) {
                prevCow = matrix[playerRow].length - 1;
            }
            matrix[playerRow][prevCow] = '-';
            playerCow++;
            if (matrix[playerRow][playerCow] == 'B') {
                beforeRecursiveRow = playerRow;
                beforeRecursiveCow = playerCow;
                moveRight(matrix, playerRow, playerCow);
                flag = true;


            }
            if (!flag) {
                matrix[playerRow][playerCow] = 'f';
            }else {
                matrix[beforeRecursiveRow][beforeRecursiveCow] = 'B';

            }
        } else {
            playerCow = prevCow;
        }
    }

    private static void moveLeft(char[][] matrix, int playerRow, int playerCow) {
        boolean flag = false;
        int beforeRecursiveRow = -1;
        int beforeRecursiveCow = -1;
        int prevCow = playerCow;
        if (playerCow - 1 == -1) {
            playerCow = matrix[playerRow].length;
        }
        if (matrix[playerRow][playerCow - 1] != 'T') {
            if (prevCow == matrix[playerRow].length) {
                prevCow = 0;
            }
            matrix[playerRow][prevCow] = '-';
            playerCow--;
            if (matrix[playerRow][playerCow] == 'B') {
                beforeRecursiveRow = playerRow;
                beforeRecursiveCow = playerCow;
                moveLeft(matrix, playerRow, playerCow);
                flag = true;
                matrix[beforeRecursiveRow][beforeRecursiveCow] = 'B';


            }
            if (!flag) {
                matrix[playerRow][playerCow] = 'f';
            }
        } else {
            playerCow = prevCow;
        }
    }
}
