import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes_04 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintWriter printWriter = new PrintWriter("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\Outputs\\outputFour.txt");

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);

                if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                    vowels++;
                } else if (currentChar == '!' || currentChar == ',' || currentChar == '.' || currentChar == '?') {
                    punctuation++;
                } else if (currentChar != ' ') {
                    consonants++;
                }
            }
        }
        String format = String.format("Vowels: %d\nConsonants: %d\nPunctuation: %d",
                vowels, consonants, punctuation);
        printWriter.println(format);
        printWriter.flush();

    }
}
