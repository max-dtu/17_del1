import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private int playerNum;
    private int balance;  
    private Die die;         
    private Scanner scanner;  
    // Define rules as a dictionary where each key is the sum, and the value is an array with points and the console message
    private Map<Integer, Object[]> sumRules = new HashMap<>() {{
        put(2, new Object[]{250, "Congrats! You rolled a 2! You gain +250 points."});
        put(3, new Object[]{-100, "Oh no! You rolled a 3! You lose -100 points."});
        put(4, new Object[]{100, "Great roll! You got a sum of 4! You earn +100 points."});
        put(5, new Object[]{-20, "Oops! Sum of 5! You lose -20 points."});
        put(6, new Object[]{180, "Nice! A 6! You gain +180 points."});
        put(7, new Object[]{0, "Sum of 7! No points earned this turn."});
        put(8, new Object[]{-70, "Uh-oh! You rolled an 8! You lose -70 points."});
        put(9, new Object[]{60, "Awesome! You rolled a 9! You earn +60 points."});
        put(10, new Object[]{-80, "Oh no! Sum of 10! You lose -80 points, but you get an extra turn!", true}); //true means grant an extra turn
        put(11, new Object[]{-50, "Bummer! You rolled an 11! You lose -50 points."});
        put(12, new Object[]{650, "Fantastic! You rolled a 12! You gain +650 points!"});
    }};

    public Player(int playerNum, int balance) {
        this.playerNum = playerNum;
        this.balance = balance; 
        this.die = new Die();  
        this.scanner = new Scanner(System.in); 
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getbalance() {
        return balance;
    }

    public boolean play() {

        System.out.println("Player " + playerNum + ", press Enter to roll the dice...");
        scanner.nextLine();  

        int die1 = die.roll();  // Roll the die
        int die2 = die.roll();
        int sum = die1 + die2;
       

        System.out.println("Player " + playerNum + " rolls: " + die1 + " and " + die2);

        if (sumRules.containsKey(sum)) {
            Object[] rule = sumRules.get(sum);
            int points = (int) rule[0];
            String message = (String) rule[1];

            // Print the rule message and update balance
            System.out.println(message);
            balance += points;

            // If there's an extra turn condition, handle it
            if (rule.length > 2 && (boolean) rule[2]) {
                 System.out.println("Player " + playerNum + " gets another turn!");
                return play();  // Recursive call for another turn
            }
        }


        // Check for a win
        if (balance >= 3000) {
            System.out.println("Player " + playerNum + " is the winner. The winner's balance: "+ balance);
            return true;
        }


        return false;  // Player hasn't won yet
    }
}

