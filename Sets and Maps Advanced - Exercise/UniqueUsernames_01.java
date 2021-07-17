package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> stringSet = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            stringSet.add(input);
        }
        stringSet.forEach(string -> System.out.println(string));
    }

}
