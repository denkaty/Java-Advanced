package CarSalesman_05;

public class Car {
    private String carModel;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.carModel = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        //<CarModel>:
        //        //<EngineModel>:
        //        //Power: <EnginePower>
        //        //Displacement: <EngineDisplacement>
        //        //Efficiency: <EngineEfficiency>
        //        //Weight: <CarWeight>
        //        //Color: <CarColor>

        String result = String.format("%s:%n" +
                "%s:%n" +
                "Power: %s%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s",
                carModel, engine.getEngineModel(),
                engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), weight, color);

        return result;
    }
}
