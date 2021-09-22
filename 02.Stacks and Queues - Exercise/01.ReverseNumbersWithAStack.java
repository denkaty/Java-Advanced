package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int currentNumber : input) {
            stack.push(currentNumber);
        }

        System.out.println(stack.toString().replaceAll("[\\[\\],]",""));


    }
}
