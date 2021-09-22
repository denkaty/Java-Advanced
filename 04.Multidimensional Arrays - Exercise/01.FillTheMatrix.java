package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = readArray(scanner);

        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix;

        if (pattern.equals("A")) {
            matrix = firstPattern(scanner, size);
        } else {
            matrix = secondPattern(scanner, size);
        }

        printMatrix(matrix);
    }

    private static String[] readArray(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(", ");
        return tokens;
    }

    private static int[][] firstPattern(Scanner scanner, int size) {
        int[][] matrixPatternA = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrixPatternA[row][col] = counter;
                counter++;
            }
        }
        return matrixPatternA;
    }

    private static int[][] secondPattern(Scanner scanner, int size) {
        int[][] matrixPatternB = new int[size][size];
        int counter = 1;

        for (int col = 0; col < size; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrixPatternB[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrixPatternB[row][col] = counter;
                    counter++;
                }
            }
        }
        return matrixPatternB;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int number = matrix[row][col];
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}