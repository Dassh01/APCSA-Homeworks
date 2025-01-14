package org.example;

import java.util.Random;

public class BankAccount {

    private long balance;
    private double interestRate;
    public int accountNumber;
    private Bank bank;
    private String ownerName;

    /**
     * Constructs bank account given inital balance and inital name
     * @param balance Initial balance
     * @param owner Initial name
     */
    //Longs should be used for something that needs extreme precision, like a bank-account balance!
    public BankAccount(long balance, String owner) {
        this.ownerName = owner;
        this.balance = balance;
    }

    /**
     * Changes the account's name
     * @param ownerName New name to change account name to
     */
    public void changeAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Changes the account's interest rate
     * @param interestRate New account interest rate
     */
    public void changeInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Apply account's internal intrestRate field to current balance
     */
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

    /**
     * Report bank account information
     * @return Bank account information as string
     */
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
