import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.list = List.of(elements);
        this.currentIndex = 0;
    }

    public List<String> getList() {
        return list;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean hasNext() {
        return currentIndex < list.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }


    public void print() {
        if (list.size() == 0) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(currentIndex));
        }
    }

    public void printAll() {

        if (list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            for (String element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size() - 1;
            }

            @Override
            public String next() {
                index++;
                return list.get(index);
            }
        };
    }
}
