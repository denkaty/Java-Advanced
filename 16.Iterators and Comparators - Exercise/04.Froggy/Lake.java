package Froggy_04;

import java.util.Iterator;


public class Lake implements Iterable<Integer> {
    private int[] jumps;
    private int index;

    public Lake(int[] jumps) {
        this.jumps = jumps;
        this.index = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return index < jumps.length;
        }

        @Override
        public Integer next() {
            int jump = jumps[index];
            index += 2;

            if (index >= jumps.length && index % 2 == 0) {
                index = 1;
            }

            return jump;
        }
    }
}
