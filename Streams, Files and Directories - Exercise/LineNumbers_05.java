import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        PrintWriter printWriter = new PrintWriter("src\\Outputs\\outputFive.txt");

        int counter = 1;
        for (String line : lines) {
            String result = String.format("%d. %s", counter, line);
            counter++;
            printWriter.println(result);
        }
        printWriter.flush();


    }
}
