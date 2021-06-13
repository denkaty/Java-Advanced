package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] matrix = {
                {1, 2, 3,4},
                {5, 6, 7,8}
        };
        int[][] secondMatrix = new int[2][];
        secondMatrix[0] = new int[3];
        secondMatrix[1] = arr;

        int[][] thirdMatrix = new int[3][3];
        thirdMatrix[0] = new int[]{1,2,3};
        thirdMatrix[1]= new int[]{4,5,6};
        thirdMatrix[2]= new int[]{7,8,9};

        int thirdMatrix1 = thirdMatrix[2][2];
        System.out.println(thirdMatrix1);

        int thirdMatrix2 = thirdMatrix[1][1];
        System.out.println(thirdMatrix2);

        int lastElement = thirdMatrix[thirdMatrix.length - 1][thirdMatrix.length - 1];
        System.out.println(lastElement);

        int[] lastArr = thirdMatrix[thirdMatrix.length-1];
        System.out.println(lastArr[lastArr.length-1]);

        System.out.println();

        for (int i = 0; i < thirdMatrix[0].length; i++) {
            System.out.println(thirdMatrix[0][i]);
        }
        for (int i = 0; i < thirdMatrix[1].length; i++) {
            System.out.println(thirdMatrix[1][i]);
        }for (int i = 0; i < thirdMatrix[2].length; i++) {
            System.out.println(thirdMatrix[2][i]);
        }


        System.out.println();
    }
}
