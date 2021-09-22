package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintWriter printWriter = new PrintWriter("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\Outputs\\outputOne.txt");
        for (String line : lines) {
            int lineASCISum = 0;
            for (int i = 0; i < line.length(); i++) {
                lineASCISum += line.charAt(i);
            }
            printWriter.println(lineASCISum);
        }
        printWriter.flush();

    }
}
