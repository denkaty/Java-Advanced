package CarSalesman_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Engine> engines = new LinkedList<>();
        List<Car> cars = new LinkedList<>();


        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            //Engine ->  <Model> <Power> <Displacement> <Efficiency>

            String model = tokens[0];
            String power = tokens[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    displacement = tokens[2];
                } else {
                    efficiency = tokens[2];
                }
            } else if (tokens.length == 4) {
                displacement = tokens[2];
                efficiency = tokens[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            //Car -> "<Model> <Engine> <Weight> <Color>",
            String[] tokens = bufferedReader.readLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            String weight = "n/a";
            String color = "n/a";

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    weight = tokens[2];
                } else {
                    color = tokens[2];
                }
            } else if (tokens.length == 4) {
                weight = tokens[2];
                color = tokens[3];
            }

            for (Engine currentEngine : engines) {
                if (engineModel.equals(currentEngine.getEngineModel())) {
                    Car car = new Car(model, currentEngine, weight, color);
                    cars.add(car);
                }
            }

        }


        for (Car car : cars) {
            System.out.println(car.toString());
        }


    }

}
