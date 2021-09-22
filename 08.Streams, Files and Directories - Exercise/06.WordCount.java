import java.io.*;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordCount_06 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        String[] checkWords = bufferedReader.readLine().split("\\s+");

        bufferedReader = new BufferedReader(new FileReader("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
        String[] textWords = bufferedReader.readLine().split("\\s+");

        Map<String, Integer> wordsCounter = new HashMap<>();
        for (String textWord : textWords) {
            for (String checkWord : checkWords) {
                if (textWord.equals(checkWord)) {
                    wordsCounter.putIfAbsent(textWord, 0);
                    int repeatingTimes = wordsCounter.get(textWord);
                    repeatingTimes++;
                    wordsCounter.put(textWord, repeatingTimes);
                }
            }

        }
        PrintWriter printWriter = new PrintWriter("src\\Outputs\\outputSix.txt");
        wordsCounter.entrySet().stream()
                .sorted((left, right) -> Integer.compare(right.getValue(), left.getValue()))
                .forEach(word -> printWriter.printf("%s - %d%n",
                        word.getKey(), word.getValue()));
        printWriter.flush();

    }
}
