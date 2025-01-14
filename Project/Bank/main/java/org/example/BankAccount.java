package org.example;

import java.util.Random;

public class BankAccount {

    private long balance;
    private double interestRate;
    public int accountNumber;
    private Bank bank;
    private String ownerName;

    public BankAccount(long balance, String owner) {
        this.ownerName = owner;
        this.balance = balance;
    }

    public void changeAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    public void changeInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance = (long) (balance * (interestRate/100 + 1));
    }

    private static int makeAccountID() {
        StringBuilder idCompile = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 8; ++i) {
            int randInt = rand.nextInt(1, 9);
            idCompile.append(randInt);
        }
        return Integer.parseInt(idCompile.toString());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", interestRate=" + interestRate +
                ", accountNumber=" + accountNumber +
                ", bank=" + bank +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

}
