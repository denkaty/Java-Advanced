package GenericCountMethodStrings_05;

public class Box5<E extends Comparable<E>> implements Comparable<E> {
    private E box;

    public Box5(E box) {
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
