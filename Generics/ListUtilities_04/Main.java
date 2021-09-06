package ListUtilities_04;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int getMax = ListUtils.getMax(integerList);

        List<String> stringList = Arrays.asList("a", "b", "c");
        String minString = ListUtils.getMin(stringList);

        System.out.println(getMax);
        System.out.println(minString);
    }
}
