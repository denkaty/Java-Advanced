import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class NestedFolders_08 {

    public static void main(String[] args) {
        File file = new File("Files-and-Streams");

        Queue<File> fileQueue = new ArrayDeque<>();
        fileQueue.offer(file);
        int counter = 1;
        while (!fileQueue.isEmpty()) {
            File poll = fileQueue.poll();
            System.out.println(poll.getName());

            File[] listFiles = poll.listFiles();
            for (File currentFile : listFiles) {
                if (currentFile.isDirectory()) {
                    fileQueue.offer(currentFile);
                    counter++;
                }
            }

        }
        System.out.println(counter + " folders");
    }
}
