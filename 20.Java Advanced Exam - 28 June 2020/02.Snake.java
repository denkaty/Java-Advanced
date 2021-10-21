import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake_02 {
//16:50 21.10.2021
//18:20 21.10.2021

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sizeOfMatrix = Integer.parseInt(bufferedReader.readLine());
        char[][] matrix = createMatrix(bufferedReader, sizeOfMatrix);
        int[] snakePosition = getSnakePosition(matrix);
        int snakeRow = snakePosition[0];
        int snakeCow = snakePosition[1];
        int[] burrowsPositions = getBurrowsPositions(matrix);
        int foodQuantityEaten = 0;


        boolean hasCrashed = false;
        boolean hasEatenEnoughFood = false;


        while (!hasCrashed && !hasEatenEnoughFood) {
            String moveCommand = bufferedReader.readLine();


            switch (moveCommand) {
                case "up":
                    if (snakeRow - 1 == -1) {
                        hasCrashed = true;
                        matrix[snakeRow][snakeCow] = '.';
                    } else {
                        if (matrix[snakeRow][snakeCow - 1] != 'B') {
                            if (matrix[snakeRow - 1][snakeCow] == '*') {
                                foodQuantityEaten++;
                                if (foodQuantityEaten == 10) {
                                    hasEatenEnoughFood = true;
                                }
                            }
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow--;
                            matrix[snakeRow][snakeCow] = 'S';
                        } else {
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow--;
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow = burrowsPositions[2];
                            snakeCow = burrowsPositions[3];

                            matrix[snakeRow][snakeCow] = 'S';
                        }
                    }
                    break;
                case "down":
                    if (snakeRow + 1 == matrix.length) {
                        hasCrashed = true;
                        matrix[snakeRow][snakeCow] = '.';
                    } else {
                        if (matrix[snakeRow + 1][snakeCow] != 'B') {
                            if (matrix[snakeRow + 1][snakeCow] == '*') {
                                foodQuantityEaten++;
                                if (foodQuantityEaten == 10) {
                                    hasEatenEnoughFood = true;
                                }
                            }
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow++;
                            matrix[snakeRow][snakeCow] = 'S';
                        } else {
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow++;
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow = burrowsPositions[2];
                            snakeCow = burrowsPositions[3];

                            matrix[snakeRow][snakeCow] = 'S';
                        }
                    }
                    break;
                case "left":
                    if (snakeCow - 1 == -1) {
                        hasCrashed = true;
                        matrix[snakeRow][snakeCow] = '.';
                    } else {
                        if (matrix[snakeRow][snakeCow - 1] != 'B') {
                            if (matrix[snakeRow][snakeCow - 1] == '*') {
                                foodQuantityEaten++;
                                if (foodQuantityEaten == 10) {
                                    hasEatenEnoughFood = true;
                                }
                            }
                            matrix[snakeRow][snakeCow] = '.';
                            snakeCow--;
                            matrix[snakeRow][snakeCow] = 'S';
                        } else {
                            matrix[snakeRow][snakeCow] = '.';
                            snakeCow--;
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow = burrowsPositions[2];
                            snakeCow = burrowsPositions[3];

                            matrix[snakeRow][snakeCow] = 'S';
                        }
                    }
                    break;
                case "right":
                    if (snakeCow + 1 == matrix[snakeRow].length) {
                        hasCrashed = true;
                        matrix[snakeRow][snakeCow] = '.';
                    } else {
                        if (matrix[snakeRow][snakeCow + 1] != 'B') {
                            if (matrix[snakeRow][snakeCow + 1] == '*') {
                                foodQuantityEaten++;
                                if (foodQuantityEaten == 10) {
                                    hasEatenEnoughFood = true;
                                }
                            }
                            matrix[snakeRow][snakeCow] = '.';
                            snakeCow++;
                            matrix[snakeRow][snakeCow] = 'S';
                        } else {
                            matrix[snakeRow][snakeCow] = '.';
                            snakeCow++;
                            matrix[snakeRow][snakeCow] = '.';
                            snakeRow = burrowsPositions[2];
                            snakeCow = burrowsPositions[3];

                            matrix[snakeRow][snakeCow] = 'S';
                        }
                    }
                    break;
            }
        }

        if (hasCrashed) {
            System.out.println("Game over!");
        } else if (hasEatenEnoughFood) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + foodQuantityEaten);

        printMatrix(matrix);


    }

    private static char[][] createMatrix(BufferedReader bufferedReader, int sizeOfMatrix) throws IOException {
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];
        for (int row = 0; row < matrix.length; row++) {
            char[] input = bufferedReader.readLine().toCharArray();
            matrix[row] = input;
        }
        return matrix;
    }

    private static int[] getSnakePosition(char[][] matrix) {
        int[] snakePosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                char currentChar = matrix[row][cow];

                if (currentChar == 'S') {
                    snakePosition[0] = row;
                    snakePosition[1] = cow;
                }
            }
        }

        return snakePosition;

    }


    private static int[] getBurrowsPositions(char[][] matrix) {
        int[] burrowsPositions = new int[4];
        int foundBurrowsCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                char currentChar = matrix[row][cow];

                if (currentChar == 'B') {
                    if (foundBurrowsCount == 0) {
                        burrowsPositions[0] = row;
                        burrowsPositions[1] = cow;
                        foundBurrowsCount++;
                    } else if (foundBurrowsCount == 1) {
                        burrowsPositions[2] = row;
                        burrowsPositions[3] = cow;
                        foundBurrowsCount++;
                    }
                }
            }
        }
        return burrowsPositions;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] rowArray : matrix) {
            for (char currentChar : rowArray) {
                System.out.print(currentChar);
            }
            System.out.println();

        }

    }
}
