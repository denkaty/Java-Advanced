import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReadFile_01 {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("D:\\SoftUni Advanced\\Streams, Files and Directories\\input.txt");
        byte[] bytes = Files.readAllBytes(path);
        for (byte oneByte : bytes) {
            String toBinaryString = Integer.toBinaryString(oneByte);
            System.out.print(toBinaryString + " ");
        }


    }
}
