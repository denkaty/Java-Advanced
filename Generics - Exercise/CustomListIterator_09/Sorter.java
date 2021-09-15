package CustomList;

public class Sorter {

    public static <E extends Comparable<E>> void sort(CustomList<E> list) {
        for (int i = 0; i < list.length(); i++) {
            E current = list.get(i);
            for (int g = i+1; g < list.length(); g++) {
                E target = list.get(g);
                if (current.compareTo(target) > 0) {
                    list.swap(i, g);
                }
            }
        }
    }


}
