import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ListFiles_07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\denis\\Desktop\\Files-and-Streams");
        File[] files = file.listFiles();

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("files-size.txt"));
        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.println(f.getName() + ":" + " " + "[" + f.length() + "]");

            }
        }
        printWriter.flush();

    }
}
