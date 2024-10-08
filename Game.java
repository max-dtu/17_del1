import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1 = new Player(1);  // Initialize Player 1
    private Player player2 = new Player(2);  // Initialize Player 2

    public void start() {
        while (true) {
            System.out.println("Player 1's turn:");
            if (player1.play()) break;  // Call play method on Player 1

            System.out.println("Player 2's turn:");
            if (player2.play()) break;  // Call play method on Player 2
        }
    }

    public static void main(String[] args) {
        Game game = new Game();  
        game.start();  
    }
}

class Die {
    private Random random;

    public Die() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1; 
    }
}

class Player {
    private int playerNum;
    private int playerScore;  // Each player has their own score
    private Die die;          // Each player has a die to roll
    private Scanner scanner;  // Scanner to read input

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.playerScore = 0; // Initialize player score
        this.die = new Die();  // Initialize the die
        this.scanner = new Scanner(System.in); // Initialize the scanner
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public boolean play() {
        System.out.println("Player " + playerNum + ", press Enter to roll the dice...");
        scanner.nextLine();  

        int die1 = die.roll();  // Roll the die
        int die2 = die.roll();
        int sum = die1 + die2;
        boolean sameDice = die1 == die2;

        System.out.println("Player " + playerNum + " rolls: " + die1 + " and " + die2);

        // Lose all points if two 1's are rolled
        if (die1 == 1 && die2 == 1) {
            playerScore = 0;  
            System.out.println("Player " + playerNum + " loses all points!");
        } else {
            playerScore += sum;  // Add sum to player's score
        }

        // Check for a win
        if (playerScore >= 40) {
            System.out.println("Player " + playerNum + " wins by reaching 40 points!");
            return true;
        }

        // If dice are the same, the player gets another turn
        if (sameDice) {
            System.out.println("Player " + playerNum + " gets another turn!");
            return play();  // Recursive call for another turn
        }

        return false;  // Player hasn't won yet
    }
}


