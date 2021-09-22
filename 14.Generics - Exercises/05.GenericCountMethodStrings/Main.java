package GenericCountMethodStrings_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Box5<String>> boxes = new ArrayList<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            Box5<String> box = new Box5<>(input);
            boxes.add(box);
        }

        Box5<String> element = new Box5<>(bufferedReader.readLine());

        int count = genericCount(boxes, element);
        System.out.println(count);
    }

    public static int genericCount(List<Box5<String>> list, Box5<String> target) {
        int count = 0;

        for (Box5<String> box : list) {
            if (box.compareTo(target.getBox()) > 0) {
                count++;
            }
        }

        return count;


    }

}
