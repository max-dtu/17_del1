   import java.util.ArrayList;

public class AccountTest {
    public static void testWithdraw(int numberOfTests) {
        Account account = new Account();
        ArrayList<Integer> balancesAfterSuccessfulWithdrawals = new ArrayList<>();
        ArrayList<Integer> balancesAfterFailedWithdrawals = new ArrayList<>();

        for (int i = 0; i < numberOfTests; i++) {
            int amountToWithdraw = (int) (Math.random() * 5000);  // Range [0, 5000[
            int amountWithdrawn = account.withdraw(amountToWithdraw);
            int balance = account.getBalance();

            if (amountWithdrawn == 0) {
                balancesAfterFailedWithdrawals.add(balance);
            } else {
                balancesAfterSuccessfulWithdrawals.add(balance);
            }
        }

        // Print the contents of both lists
        System.out.println("Successful Withdrawals (Balances): " + balancesAfterSuccessfulWithdrawals);
        System.out.println("Failed Withdrawals (Balances): " + balancesAfterFailedWithdrawals);

        // Check for any negative balances
        checkForNegativeValues(balancesAfterSuccessfulWithdrawals, "balancesAfterSuccessfulWithdrawals");
        checkForNegativeValues(balancesAfterFailedWithdrawals, "balancesAfterFailedWithdrawals");
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
            System.out.println("Warning: Negatives found in the " + listName + " array");
        }else{
            System.out.println("No Negatives found in the " + listName + " array");
        }
    }
}