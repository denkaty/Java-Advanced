package BankAccount_02;

import java.text.DecimalFormat;

public class BankAccount {

    private static int idCounter = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = BankAccount.idCounter;
        BankAccount.idCounter++;
        System.out.println(String.format("Account ID%d created", this.id));
    }

    public static void setInterestRate(double interest) {
       BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return (this.balance * BankAccount.interestRate) * years;
    }

    public void deposit(double ammount) {
        this.balance += ammount;

        DecimalFormat decimalFormat = new DecimalFormat("#");

        System.out.println(String.format("Deposited %s to ID%d", decimalFormat.format(ammount), this.id));
    }

    public int getId() {
        return this.id;
    }
}
