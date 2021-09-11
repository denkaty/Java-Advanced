package GenericSwapMethodInteger_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Box4<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            Box4<Integer> box = new Box4<>(Integer.parseInt(input));

            boxes.add(box);
        }

        int[] indexes = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swapElements(boxes, indexes[0], indexes[1]);
        for (Box4<Integer> box : boxes) {
            System.out.println(box);
        }


    }

    public static <E> void swapElements(List<E> list, int firstIndex, int secondIndex) {
        E firstElement = list.get(firstIndex);
        E secondElement = list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
    }
}
