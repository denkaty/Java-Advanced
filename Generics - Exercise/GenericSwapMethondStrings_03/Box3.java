package GenericSwapMethondStrings_03;

public class Box3<E> {
    private E box;

    public Box3(E box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return box.getClass().getName() + ": " + box;
    }
}
