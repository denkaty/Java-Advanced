package Threeuple_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Threeuple> threeuples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            switch (i) {
                case 0:
                    String fullName = tokens[0] + " " + tokens[1];
                    String address = tokens[2];
                    String town = tokens[3];

                    Threeuple<String, String, String> threeuple1 = new Threeuple<>(fullName, address, town);

                    threeuples.add(threeuple1);
                    break;
                case 1:
                    String name = tokens[0];
                    int litersOfBeer = Integer.parseInt(tokens[1]);
                    String drunkOrNot = tokens[2];

                    boolean drunkOrNotBoolean = false;

                    if (drunkOrNot.equals("drunk")) {
                        drunkOrNotBoolean = true;
                    }

                    Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(name, litersOfBeer, drunkOrNotBoolean);

                    threeuples.add(threeuple2);
                    break;
                case 2:
                    String person = tokens[0];
                    double accountBalance = Double.parseDouble(tokens[1]);
                    String bankName = tokens[2];

                    Threeuple<String, Double, String> threeuple3 = new Threeuple<>(person, accountBalance, bankName);

                    threeuples.add(threeuple3);
                    break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Threeuple threeuple : threeuples) {
            stringBuilder.append(threeuple).append("\n");
        }
        System.out.println(stringBuilder.toString());

    }
}
