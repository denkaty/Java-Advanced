import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializeArrayList_10 {

    public static void main(String[] args) throws IOException {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\Outputs\\outputTen.ser"));

        for (Integer integer : integers) {
            objectOutputStream.write(integer);

        }


    }

}
