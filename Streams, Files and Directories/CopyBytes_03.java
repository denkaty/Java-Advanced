import java.io.*;
import java.nio.file.Files;


public class CopyBytes_03 {

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");

        byte[] bytes = Files.readAllBytes(file.toPath());

        Writer writer = new FileWriter("text-as-bytes.txt");
        for (byte b : bytes) {
            String out = String.valueOf(b);
            if (b == 32) {
                out = " ";
            } else if (b == 10) {
                out = System.lineSeparator();
            }
            writer.write(out);
        }
        writer.close();


    }
}
