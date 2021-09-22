import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteToFile_02 {

    public static void main(String[] args) throws IOException {

        String location = "D:\\SoftUni Advanced\\Streams, Files and Directories\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(location);

        Scanner scanner = new Scanner(fileInputStream);

        String line = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (line != null) {
            stringBuilder.append(line.replaceAll("[,.!?]", ""));
            stringBuilder.append(System.lineSeparator());

            try {
                line = scanner.nextLine();
            } catch (NoSuchElementException exception) {
                fileInputStream.close();
                break;
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.print(stringBuilder.toString());
        printWriter.close();

    }
}
