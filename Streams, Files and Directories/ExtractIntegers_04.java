import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class ExtractIntegers_04 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        FileOutputStream fileOutputStream = new FileOutputStream("integers.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int nextInt = scanner.nextInt();
                printWriter.println(nextInt);
            }else {
                scanner.next();
            }
        }
        printWriter.flush();
    }
}
