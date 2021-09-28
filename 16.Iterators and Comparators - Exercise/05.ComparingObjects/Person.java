package ComparingObjects_05;

public class Person implements Comparable<Person> {
    private String name;
    private int years;
    private String city;

    public Person(String name, int years, String city) {
        this.name = name;
        this.years = years;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().compareTo(other.getName()) == 0) {
            if (Integer.compare(this.getYears(), other.getYears()) == 0) {
                if (this.getCity().compareTo(other.getCity()) == 0) {
                    return 0;
                }
            }
        }
            return -1;
    }
}
