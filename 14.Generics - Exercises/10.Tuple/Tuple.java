package Tuple_10;

public class Tuple<E1, E2> {

    private E1 item1;
    private E2 item2;

    public Tuple(E1 item1, E2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E1 getItem1() {
        return item1;
    }

    public E2 getItem2() {
        return item2;
    }

@Override
    public String toString(){
        return this.item1 + " -> " + this.item2;
    }
}
