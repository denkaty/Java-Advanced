import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GetFolderSize_08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        int size = 0;
        File[] files = file.listFiles();
        for (File file1 : files) {
            size+=file1.length();
        }
        PrintWriter printWriter = new PrintWriter("D:\\SoftUni Advanced\\Streams, Files and Directories - Exercise\\src\\Outputs\\outputEight.txt");
        printWriter.println("Folder size: "+ size);
        printWriter.flush();


    }
}
