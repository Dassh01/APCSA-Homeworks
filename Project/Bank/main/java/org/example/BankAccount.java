package org.example;

import java.util.Random;

public class BankAccount {

    final int accessLimit = 20;

    private long balance;
    private double interestRate;
    public int accountNumber;
    private Bank bank;
    private String ownerName;
    private int timesAccessed;
    private boolean exceededFreeAccessLimit;

    /**
     * Constructs bank account given inital balance and inital name
     * @param balance Initial balance
     * @param owner Initial name
     */
    //Longs should be used for something that needs extreme precision, like a bank-account balance!
    public BankAccount(long balance, String owner) {
        this.ownerName = owner;
        this.balance = balance;
        accountNumber = makeAccountID();
    }

    public void updateFreeAccessLimit() {
        timesAccessed += 1;
        exceededFreeAccessLimit = timesAccessed > accessLimit;
    }

    public void deposit(long depositAmtDlrs) {
        balance += depositAmtDlrs;
        updateFreeAccessLimit();
    }

    public void withdraw(long withdrawAmtDlrs) {
        balance -= withdrawAmtDlrs;
        updateFreeAccessLimit();
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

    //Why did you have us make this??
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
     * Deducts monthly charge, returns true if monthly charges were deducted, returns false if user
     * still had free accesses left
     * @return true if monthly charges were deducted, false if they weren't
     */
    public boolean deductMonthlyCharge() {
        if (timesAccessed <= 20) {
            timesAccessed = 0;
            return false;
        }
        else {
            timesAccessed = 0;
            balance -= (20 * (accessLimit - timesAccessed)); //Charges $20 for every access over the free charges limit
            return true;
        }
    }
    /**
     * Report bank account information
     * @return Bank account information as string
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "\nbalance=" + balance +
                ",\ninterestRate=" + interestRate +
                ", \naccountNumber=" + accountNumber +
                ", \nbank=" + bank +
                ", \nownerName='" + ownerName +
                ", \nFree transactions left = " + (accessLimit - timesAccessed) +
                "\n}";
    }

}
