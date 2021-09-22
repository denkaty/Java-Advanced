package RawData_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new LinkedList<>();

        Car car;

        Engine engine;
        Cargo cargo;
        Tire tire1;
        Tire tire2;
        Tire tire3;
        Tire tire4;

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            engine = new Engine(engineSpeed, enginePower);
            cargo = new Cargo(cargoWeight, cargoType);
            tire1 = new Tire(tire1Pressure, tire1Age);
            tire2 = new Tire(tire2Pressure, tire2Age);
            tire3 = new Tire(tire3Pressure, tire3Age);
            tire4 = new Tire(tire4Pressure, tire4Age);

            car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            cars.add(car);
        }

        String command = bufferedReader.readLine();
        List<String> output = new LinkedList<>();

        if (command.equals("fragile")) {
            cars.forEach(currentCar -> {
                if (currentCar.getCargo().getCargoType().equals("fragile")) {
                    for (Tire tire : currentCar.getTires()) {
                        if (tire.getTirePressure() < 1) {
                            output.add(currentCar.getModel());
                            break;
                        }
                    }

                }
            });
        } else if (command.equals("flamable")) {
            cars.forEach(currentCar -> {
                if (currentCar.getCargo().getCargoType().equals("flamable")) {
                    if (currentCar.getEngine().getEnginePower() > 250) {
                        output.add(currentCar.getModel());
                    }
                }
            });
        }
        for (String carModel : output) {
            System.out.println(carModel);
        }

    }
}
