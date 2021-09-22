package CarSalesman_05;

public class Engine {
    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.engineModel = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
