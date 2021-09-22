package GenericCountMethodDoubles_06;

public class Box6<E extends Comparable<E>> implements Comparable<E> {
    private E box;

    public Box6(E box) {
        this.box = box;
    }

    public E getBox() {
        return box;
    }

    @Override
    public int compareTo(E o) {
        return box.compareTo(o);
    }
}
