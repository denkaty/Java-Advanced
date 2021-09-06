package ListUtilities_04;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    private ListUtils() {

    }

    public static <T extends Comparable<T>> T getMax(List<T> list) throws IllegalAccessException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.max(list);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) throws IllegalAccessException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.min(list);
    }
}
