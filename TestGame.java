public class TestGame {

//The String[] args parameter allows you to pass command-line arguments to the program. These arguments are passed as strings and can be accessed in the args array. for example: java TestGame 2000


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

        testDieRoll(numRolls);
    }

    // Test the Die class by rolling it a user-specified number of times
    public static void testDieRoll(int numRolls) {
        Die die = new Die();
        int[] rollCounts = new int[6];  // Array to store the counts for each die face (1-6)
        int twins = 0;  // Counter for twins
        int[] sumArr = new int[13];  // Array for sums of two dice rolls (possible sums: 2-12)

        System.out.println("Testing Die class with " + numRolls + " rolls:");

        // Roll the die numRolls times (i.e. 1000 times)
        for (int i = 0; i < numRolls; i++) {
            int roll1 = die.roll();
            int roll2 = die.roll();

            if (roll1 >= 1 && roll1 <= 6 && roll2 >= 1 && roll2 <= 6) {
                rollCounts[roll1 - 1]++; 
                rollCounts[roll2 - 1]++;  

                if (roll1 == roll2) {
                    twins++;  // Increment the twins count (when both rolls are equal)
                }

                int sumOfTheTwo = roll1 + roll2;
                sumArr[sumOfTheTwo]++;  
            } else {
                System.out.println("Error: Die rolled out of range.");
            }
        }

        
        for (int i = 0; i < 6; i++) {
            System.out.println("Die face " + (i + 1) + " rolled " + rollCounts[i] + " times.");
        }

        
        System.out.println("Sums of two dice:");
        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum " + i + " occurred " + sumArr[i] + " times.");
        }

        
        System.out.println("Twins (both dice rolled the same) occurred " + twins + " times.");
        System.out.println();
    }

    
}
