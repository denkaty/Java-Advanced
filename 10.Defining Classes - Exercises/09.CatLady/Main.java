package CatLady_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new LinkedHashMap<>();

        String input = "";
        while (!"End".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String catBreed = tokens[0];
            String catName = tokens[1];

            Cat cat = null;
            if (catBreed.equals("Siamese")) {
                double catEarSize = Double.parseDouble(tokens[2]);
                cat = new Siamese(catName, catEarSize);
            } else if (catBreed.equals("Cymric")) {
                double catFurLength = Double.parseDouble(tokens[2]);
                cat = new Cymric(catName, catFurLength);
            } else if (catBreed.equals("StreetExtraordinaire")) {
                double catDecibelsOfMeows = Double.parseDouble(tokens[2]);
                cat = new StreetExtraordinaire(catName, catDecibelsOfMeows);
            }

            cats.put(catName,cat);
        }

        String nameOfACat = bufferedReader.readLine();
        System.out.println(cats.get(nameOfACat).toString());


    }
}
