import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_06 {

    public static void main(String[] args) throws IOException {

//        List<String> allLines = Files.readAllLines(Paths.get("input.txt"))
//                .stream()
//                .sorted((left, right) -> left.compareTo(right))
//                .collect(Collectors.toList());
//
//        Files.write(Paths.get("sorted-lines.txt"), allLines);

        Path path = Paths.get("input.txt");
        Path output = Paths.get("sorted-lines.txt");

        List<String> allLines = Files.readAllLines(path)
                .stream()
                .filter(line -> !line.isBlank())
                .collect(Collectors.toList());

        Collections.sort(allLines);

        Files.write(output,allLines);
    }
}
