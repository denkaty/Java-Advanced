package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<E extends Comparable<E>> {
    private List<E> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    //start
    public void add(E element) {
        this.list.add(element);
    }
    //end


    //start
    public E remove(int index) {
        if (isNotInRange(index)) {
            return null;
        }
        return this.list.remove(index);
    }
    //end


    //start
    public boolean contains(E element) {
        return this.list.contains(element);
    }
    //end


    //start
    public void swap(int firstIndex, int secondIndex) {
        if (isNotInRange(firstIndex) || isNotInRange(secondIndex)) {
            System.out.println("FirstIndex/SecondIndex is not a valid index!");
        } else {
            E firstElement = this.list.get(firstIndex);
            E secondElement = this.list.get(secondIndex);

            this.list.set(firstIndex, secondElement);
            this.list.set(secondIndex, firstElement);
        }
    }
    //end


    //start
    public int countGreaterThan(E element) {
        int count = 0;
        for (E e : this.list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
    //end


    //start
    public E getMax() {
        E max = this.list.get(0);
        for (E current : this.list) {
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
    //end


    //start
    public E getMin() {
        E min = this.list.get(0);
        for (E current : this.list) {
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }
    //end

    //start
    public int length() {
        int length = 0;
        for (E e : list) {
            length++;
        }
        return length;

    }
    //end

    public E get(int i) {
        int counter = -1;
        for (E e : list) {
            counter++;

            if (counter == i) {
                return e;
            }
        }

        return null;


    }


    //
    private boolean isNotInRange(int index) {
        return index < 0 || index >= this.list.size();
    }

    public void print() {
        for (E e : list) {
            System.out.println(e);
        }

    }
    //


}
