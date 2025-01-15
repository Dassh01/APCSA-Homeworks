package org.example;

public class Main {
    public static void main(String[] args) {
        //generalTests();
        monthlyAccessTests();
    }

    public static void monthlyAccessTests() {
        BankAccount account = new BankAccount(1000,"Tabby");
        for (int i = 0; i < 3; ++i ) { //Test for 4 months
            System.out.println("Month: " + (i+1));
            singleMonthTest(account);
        }
    }

    public static void singleMonthTest(BankAccount account) {
        System.out.println("Account initial status: \n" + account);

        for (int i = 0; i < 25; ++i) { //Max out account free accesses (goes 5 over the limit so about $100)
            account.deposit(5);
        }

        System.out.println("Account post max access status: \n" + account);
        account.deductMonthlyCharge();
        System.out.println("Account status post monthly charge: \n" + account);
    }


    public static void generalTests() {
        //init
        BankAccount account = new BankAccount(100,"Henry Felated");
        System.out.println(account);

        //Change account name
        account.changeAccount("Benry Felated (Formerly Henry Felated)");
        account.changeInterestRate(5);
        System.out.println(account);

        //Apply interest rate
        System.out.println("Applying interest rate");
        account.applyInterest();
        System.out.println(account);

        //Withdraw 5 dollars
        System.out.println("Taking 5 dollars");
        account.withdraw(5);
        System.out.println(account);

        //Deposit 5 dollars
        System.out.println("Depositing 5 dollars");
        account.deposit(5);
        System.out.println(account);
    }
}