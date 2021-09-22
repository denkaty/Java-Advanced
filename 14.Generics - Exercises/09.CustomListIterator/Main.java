package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> customList = new CustomList<String>();
        String input = "";
        while (!"END".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            if (command.equals("Add")) {
                String element = tokens[1];
                customList.add(element);
            } else if (command.equals("Remove")) {
                int index = Integer.parseInt(tokens[1]);
                customList.remove(index);
            } else if (command.equals("Contains")) {
                String element = tokens[1];
                System.out.println(customList.contains(element));
            } else if (command.equals("Swap")) {
                int firstIndex = Integer.parseInt(tokens[1]);
                int secondIndex = Integer.parseInt(tokens[2]);
                customList.swap(firstIndex, secondIndex);
            } else if (command.equals("Greater")) {
                String element = tokens[1];
                System.out.println(customList.countGreaterThan(element));
            } else if (command.equals("Max")) {
                System.out.println(customList.getMax());
            } else if (command.equals("Min")) {
                System.out.println(customList.getMin());
            } else if (command.equals("Sort")) {
                Sorter.sort(customList);
            } else if (command.equals("Print")) {
                customList.print();
            }

        }

    }
}
