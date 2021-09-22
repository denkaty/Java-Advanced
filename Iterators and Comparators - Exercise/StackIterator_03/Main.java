package StackIterator_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        CustomStack customStack = new CustomStack();
        while (!"END".equals(input = bufferedReader.readLine())) {
            input = input.replaceAll(",", "");
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            if (command.equals("Push")) {

                Integer[] integers = Arrays.stream(tokens).skip(1).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                customStack.push(integers);
            } else if (command.equals("Pop")) {
                customStack.pop();
            }

        }

        for (Integer integer : customStack) {
            System.out.println(integer);
        }
        for (Integer integer : customStack) {
            System.out.println(integer);
        }
    }

}
