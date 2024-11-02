import java.util.ArrayList;

public class BankAccountTest {
    public static void testWithdraw(int numberOfTests) {
        BankAccount account = new BankAccount("Bob", "43234522");
        ArrayList<Double> balancesAfterSuccessfulWithdrawals = new ArrayList<>();
        ArrayList<Double> balancesAfterFailedWithdrawals = new ArrayList<>();

        for (int i = 0; i < numberOfTests; i++) {
            int amountToWithdraw = (int) (Math.random() * 5000); // Range [0, 5000[
            double amountWithdrawn = account.withdraw(amountToWithdraw);
            double balance = account.getBalance();

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
    private static void checkForNegativeValues(ArrayList<Double> balances, String listName) {
        boolean negativeFound = false;
        for (double balance : balances) {
            if (balance < 0) {
                negativeFound = true;
                System.out.println("Warning: Negative balance detected in " + listName + ": " + balance);
            }
        }

        if (negativeFound) {
            System.out.println("Warning: Negatives found in the " + listName + " array");
        } else {
            System.out.println("No Negatives found in the " + listName + " array");
        }
    }
}