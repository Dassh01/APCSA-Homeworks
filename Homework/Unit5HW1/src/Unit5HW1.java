public class Unit5HW1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000,"Henry");
        account.changeAccount("Bea");
        account.changeInterestRate(5);
        account.enforceInterest();
        System.out.println(account);
    }
}
