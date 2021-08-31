package SpeedRacing_03;

public class Car {
    private String carModel;
    private double fuelAmount;
    private double fuelCostForOneKilometre;
    private int kilometresTravelled = 0;

    public Car(String carModel, double fuelAmount, double fuelCostForOneKilometre) {
        this.carModel = carModel;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometre = fuelCostForOneKilometre;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostForOneKilometre() {
        return fuelCostForOneKilometre;
    }

    public void setFuelCostForOneKilometre(double fuelCostForOneKilometre) {
        this.fuelCostForOneKilometre = fuelCostForOneKilometre;
    }

    public int getKilometresTravelled() {
        return kilometresTravelled;
    }

    public void setKilometresTravelled(int kilometresTravelled) {
        this.kilometresTravelled = kilometresTravelled;
    }

    public boolean checkFuel(double distance) {
        if (fuelAmount - (fuelCostForOneKilometre * distance) >= 0) {
            return true;
        }
        return false;
    }

}
