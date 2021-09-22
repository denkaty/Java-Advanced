package GenericSwapMethodInteger_04;

public class Box4<E extends Number> {
    private E box;

    public Box4(E box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return box.getClass().getName() + ": " + box;
    }
}
