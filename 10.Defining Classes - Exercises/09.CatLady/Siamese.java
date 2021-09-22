package CatLady_09;

public class Siamese extends Cat {
    private String catName;
    private double catEarSize;

    public Siamese(String catName, double catEarSize) {
        super(catName);
        this.catEarSize = catEarSize;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getCatEarSize() {
        return catEarSize;
    }

    public void setCatEarSize(double catEarSize) {
        this.catEarSize = catEarSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.02f", super.getCatName(), getCatEarSize());
    }
}
