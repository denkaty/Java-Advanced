package Froggy_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] jumps = Arrays.stream(bufferedReader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(jumps);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer jump : lake) {
            stringBuilder.append(jump).append(", ");
        }


        System.out.println(stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()));


    }
}
