package Tuple_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            switch (i) {
                case 0:
                    String fullName = tokens[0] + " " + tokens[1];
                    String address = tokens[2];

                    Tuple<String, String> tuple1 = new Tuple<>(fullName, address);
                    System.out.println(tuple1);
                    break;
                case 1:
                    String name = tokens[0];
                    int litersOfBeer = Integer.parseInt(tokens[1]);

                    Tuple<String, Integer> tuple2 = new Tuple<>(name, litersOfBeer);
                    System.out.println(tuple2);
                    break;
                case 2:
                    int inputInteger = Integer.parseInt(tokens[0]);
                    double inputDouble = Double.parseDouble(tokens[1]);

                    Tuple<Integer, Double> tuple3 = new Tuple<>(inputInteger, inputDouble);
                    System.out.println(tuple3);
                    break;
            }
        }
    }
}
