   import java.util.ArrayList;

public class AccountTest {
    public static void testWithdraw(int numberOfTests) {
        Account account = new Account();
        ArrayList<Integer> successfulWithdrawals = new ArrayList<>();
        ArrayList<Integer> failedWithdrawals = new ArrayList<>();

        for (int i = 0; i < numberOfTests; i++) {
            int amountToWithdraw = (int) (Math.random() * 5000);  // Range [0, 5000[
            int amountWithdrawn = account.withdraw(amountToWithdraw);
            int balance = account.getBalance();

            if (amountWithdrawn == 0) {
                failedWithdrawals.add(balance);
            } else {
                successfulWithdrawals.add(balance);
            }
        }

        // Print the contents of both lists
        System.out.println("Successful Withdrawals (Balances): " + successfulWithdrawals);
        System.out.println("Failed Withdrawals (Balances): " + failedWithdrawals);

        // Check for any negative balances
        checkForNegativeValues(successfulWithdrawals, "Successful Withdrawals");
        checkForNegativeValues(failedWithdrawals, "Failed Withdrawals");
    }

    // Helper method to check for negative values in a list
    private static void checkForNegativeValues(ArrayList<Integer> balances, String listName) {
        boolean negativeFound = false;
        for (int balance : balances) {
            if (balance < 0) {
                negativeFound = true;
                System.out.println("Warning: Negative balance detected in " + listName + ": " + balance);
            }
        }

        if(negativeFound){
            System.out.println("Warning: Negative found");
        }else{
            System.out.println("No Negative found");
        }
    }
}