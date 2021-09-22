import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = getDegrees(scanner);

        ArrayList<String> inputWords = readInputWords(scanner);
        int rows = inputWords.size();
        int length = maxLength(inputWords);

        char[][] matrix = createMatrix(inputWords, rows, length);

        if (degrees == 0) {
            print(inputWords, length, matrix);
        } else if (degrees == 90) {
            oneRotation(inputWords, length, matrix);
        } else if (degrees == 180) {
            twoRotations(inputWords, length, matrix);
        } else if (degrees == 270) {
            threeRotations(inputWords, length, matrix);
        }


    }

    private static int getDegrees(Scanner scanner) {
        String command = scanner.nextLine();

        Pattern pattern = Pattern.compile("([A-Za-z]+)\\((?<degrees>[0-9]+)\\)");
        Matcher matcher = pattern.matcher(command);

        int degrees = 0;
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group("degrees"));
        }

        while (degrees >= 360) {
            degrees = degrees % 360;
        }
        return degrees;
    }


    private static ArrayList<String> readInputWords(Scanner scanner) {
        ArrayList<String> inputWords = new ArrayList<>();
        String command = "";
        while (!"END".equals(command = scanner.nextLine())) {
            String inputWord = command;
            inputWords.add(inputWord);
        }
        return inputWords;
    }


    private static int maxLength(ArrayList<String> inputWords) {
        int maxLength = Integer.MIN_VALUE;
        for (String currentWord : inputWords) {
            int currentWordLength = currentWord.length();
            if (currentWordLength > maxLength) {
                maxLength = currentWordLength;
            }
        }
        int cols = maxLength;
        return cols;
    }


    private static char[][] createMatrix(ArrayList<String> inputWords, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String wordToAdd = inputWords.get(row);
            int wordLength = wordToAdd.length();
            for (int col = 0; col < wordLength; col++) {

                char currentChar = wordToAdd.charAt(col);

                matrix[row][col] = currentChar;
            }
            for (int col = wordLength; col < cols; col++) {
                matrix[row][col] = ' ';
            }
        }

        return matrix;
    }

    private static void oneRotation(ArrayList<String> inputWords, int length, char[][] matrix) {
        char[][] newMatrix = new char[length][inputWords.size()];

        int i = 0;
        for (int col = matrix.length - 1; col >= 0; col--) {
            int j = 0;
            for (int row = 0; row < matrix[i].length; row++) {
                newMatrix[row][col] = matrix[i][j];
                j++;
            }
            i++;
        }

        print(inputWords, length, newMatrix);


    }

    private static void threeRotations(ArrayList<String> inputWords, int length, char[][] matrix) {
        char[][] newMatrix = new char[length][inputWords.size()];
        int i = 0;
        for (int c = 0; c < newMatrix[inputWords.size()].length; c++) {
            int j = 0;
            for (int r = newMatrix.length - 1; r >= 0; r--) {
                if (j < matrix[i].length) {
                    newMatrix[r][c] = matrix[i][j];
                }
                j++;
            }
            i++;
        }
        print(inputWords, length, newMatrix);
    }

    private static void twoRotations(ArrayList<String> inputWords, int length, char[][] matrix) {
        char[][] newMatrix = new char[inputWords.size()][length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                newMatrix[matrix.length - 1 - row][col] = matrix[row][matrix[row].length - 1 - col];
            }
        }

        print(inputWords, length, newMatrix);
    }

    private static void print(ArrayList<String> inputWords, int length, char[][] newMatrix) {
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                System.out.print(newMatrix[row][col]);
            }
            System.out.println();
        }
    }
}
