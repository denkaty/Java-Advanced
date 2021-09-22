package GenericCountMethodDoubles_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Box6<Double>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(bufferedReader.readLine());
            Box6<Double> box = new Box6<>(input);
            boxes.add(box);
        }

        Box6<Double> target = new Box6<>(Double.parseDouble(bufferedReader.readLine()));
        int count = countMethod2(boxes, target);
        System.out.println(count);

    }

    private static int countMethod2(List<Box6<Double>> boxes, Box6<Double> target) {
        int count = 0;
        for (Box6<Double> box : boxes) {
            if (box.compareTo(target.getBox()) > 0) {
                count++;
            }
        }

        return count;
    }
}
