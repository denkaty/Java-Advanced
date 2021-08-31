package SpeedRacing_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {

            String[] tokens = bufferedReader.readLine().split("\\s+");

            String carModel = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostForOneKilometre = Double.parseDouble(tokens[2]);

            Car currentCar = new Car(carModel, fuelAmount, fuelCostForOneKilometre);

            cars.add(currentCar);
        }

        String input = "";
        while (!"End".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String carModel = tokens[1];
            int distance = Integer.parseInt((tokens[2]));

            for (Car car : cars) {
                if (car.getCarModel().equals(carModel)) {
                    if (car.checkFuel(distance)) {
                        car.setFuelAmount(car.getFuelAmount() - (car.getFuelCostForOneKilometre() * distance));
                        car.setKilometresTravelled(car.getKilometresTravelled() + distance);
                        break;
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
        }

        cars.forEach(car -> {
            System.out.println(String.format("%s %.02f %d",
                    car.getCarModel(), car.getFuelAmount(), car.getKilometresTravelled()));
        });


    }

}
