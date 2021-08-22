package BankAccount_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccountMap.put(bankAccount.getId(), bankAccount);
            } else if (command.equals("Deposit")) {
                int bankAccountId = Integer.parseInt(tokens[1]);
                if (bankAccountMap.containsKey(bankAccountId)){
                    BankAccount bankAccount = bankAccountMap.get(bankAccountId);
                    bankAccount.deposit(Double.parseDouble(tokens[2]));
                }else {
                    System.out.println("Account does not exist");
                }

            } else if (command.equals("SetInterest")) {
                double newInterestRate = Double.parseDouble(tokens[1]);
               BankAccount.setInterestRate(newInterestRate);

            } else {
                int bankAccountId = Integer.parseInt(tokens[1]);
                if (bankAccountMap.containsKey(bankAccountId)){
                    BankAccount bankAccount = bankAccountMap.get(bankAccountId);
                    System.out.printf("%.2f%n", bankAccount.getInterest(Integer.parseInt(tokens[2])));
                }else {
                    System.out.println("Account does not exist");
                }

            }
        }

    }
}
