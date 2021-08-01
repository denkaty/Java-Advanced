import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine_05 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("every-third-line.txt"));

        String line = bufferedReader.readLine();
        int counter = 1;
        while (line!=null){
            if (counter%3==0){
                printWriter.println(line);
            }

            try {
                line = bufferedReader.readLine();
                counter++;
            } catch (IOException exception) {
               bufferedReader.close();
            }
        }
        printWriter.flush();

    }
}
