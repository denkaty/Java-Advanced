package CatLady_09;

public class Cymric extends Cat {
    private String catName;
    private double catFurLength;

    public Cymric(String catName, double catFurLength) {
        super(catName);
        this.catFurLength = catFurLength;
    }


    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getCatFurLength() {
        return catFurLength;
    }

    public void setCatFurLength(double catFurLength) {
        this.catFurLength = catFurLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.02f", super.getCatName(), getCatFurLength());
    }
}
