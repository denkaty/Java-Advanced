import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFIles_07 {

    public static void main(String[] args) throws IOException {
        List<String> fileOne = Files.readAllLines(Path.of("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        List<String> fileTwo = Files.readAllLines(Path.of("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));

        PrintWriter printWriter = new PrintWriter("src\\Outputs\\outputSeven.txt");

        for (String line : fileOne) {
            printWriter.println(line);
        }
        for (String line : fileTwo) {
            printWriter.println(line);
        }
        printWriter.flush();


    }
}
