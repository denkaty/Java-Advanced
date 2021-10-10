package StrategyPattern_06;


import java.util.Comparator;

public class CompareByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int firstLength = o1.getName().length();
        int secondLength = o2.getName().length();

        if (firstLength > secondLength) {
            return 1;
        } else if (firstLength == secondLength){
            char first = o1.getName().toUpperCase().charAt(0);
            char second = o2.getName().toUpperCase().charAt(0);

            if (first > second) {
                return 1;
            }
        }
        return -1;
    }

}
