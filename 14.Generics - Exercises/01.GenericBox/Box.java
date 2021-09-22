package GenericBox_01;

public class Box<E> {
    private E box;

    public Box(E box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return box.getClass().getName() + ": " + box;
    }
}
