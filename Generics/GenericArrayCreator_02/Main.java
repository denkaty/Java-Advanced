package GenericArrayCreator_02;

public class Main {

    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);
    }
}
