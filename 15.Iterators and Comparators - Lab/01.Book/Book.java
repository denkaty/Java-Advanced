package Book_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String[] authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }

    }


}
