import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes_02 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintWriter printWriter = new PrintWriter("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\Outputs\\outputTwo.txt");

        int ASCIISum = 0;
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                ASCIISum += line.charAt(i);
            }
        }
        printWriter.println(ASCIISum);
        printWriter.flush();

    }
}
