public class Account {
    private int balance = 1000;


    public boolean deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            return true; 
        }
        return false;
    }

    public int withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return amount;
        } 
        return 0;
    }

     public int getBalance() {
        return balance;
    }

}
