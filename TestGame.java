

public class TestGame {



    public static void main(String[] args) {

        // Test the Die class with a user-specified number of rolls
        int numRolls = 1000;  // Set default to 1000
        if (args.length > 0) {
            try {
                numRolls = Integer.parseInt(args[0]);  // Parse the argument to get the number of rolls
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument for number of rolls. Using default: 1000.");
            }
        }

        DieTest.testDieRoll(numRolls);
        AccountTest.testWithdraw(1000);
    }
    
}
