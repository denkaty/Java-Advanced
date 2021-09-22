package GenericBoxOfInteger_02;

public class Box2<E> {
    private E box;

    public Box2(E box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return box.getClass().getName() + ": " + box;
    }
}

