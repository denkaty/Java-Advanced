import java.io.*;

public class CopyAPicture_09 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\изтеглен файл.png"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src\\Outputs\\copy.jpg"));

        byte[] buffer = new byte[1024];

        int read = 0;
        while ((read = fileInputStream.read(buffer))>0){
            fileOutputStream.write(buffer,0,read);
        }
        fileOutputStream.flush();
    }
}
