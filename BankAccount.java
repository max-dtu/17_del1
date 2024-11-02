public class BankAccount {
    private double balance;
    private String owner;
    private String accountNumber;

    BankAccount(String owner, String accountNumber) {

        this.owner = owner;

        this.accountNumber = accountNumber;

        this.balance = 1000;

    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public double withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return amount;
        }
        return 0;
    }

    double transfer(BankAccount destination, double amount) {

        var transferredAmount = this.withdraw(amount);

        destination.deposit(transferredAmount);

        return transferredAmount;

    }

    public double getBalance() {
        return balance;
    }

    public String description() {

        return "Account " + this.accountNumber + " owned by " + this.owner + ": " + this.balance + " DKK";

    }

}
