package CatLady_09;

public class StreetExtraordinaire extends Cat {
    private String catName;
    private double catDecibelsOfMeows;

    public StreetExtraordinaire(String catName, double catDecibelsOfMeows) {
        super(catName);
        this.catDecibelsOfMeows = catDecibelsOfMeows;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getCatDecibelsOfMeows() {
        return catDecibelsOfMeows;
    }

    public void setCatDecibelsOfMeows(double catDecibelsOfMeows) {
        this.catDecibelsOfMeows = catDecibelsOfMeows;
    }
@Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.02f", super.getCatName(), getCatDecibelsOfMeows());
    }
}
