package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100,"Henry Felated");
        System.out.println(account);
        account.changeAccount("Benry Felated (Formerly Henry Felated)");
        account.changeInterestRate(5);
        System.out.println(account);
        System.out.println("Applying interest rate");
        account.applyInterest();
        System.out.println(account);
    }
}