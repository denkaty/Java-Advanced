package GenericBoxOfInteger_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            Box2<Integer> box = new Box2<>(Integer.parseInt(bufferedReader.readLine()));
            System.out.println(box);
        }
    }
}
