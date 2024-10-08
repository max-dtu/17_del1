import java.util.Random;

public class Game {
    private int player1Score;
    private int player2Score;
    private Random random;

    public Game() {
        player1Score = 0;
        player2Score = 0;
        random = new Random();
    }

    // Rolls a single die (returns a value between 1 and 6)
    private int rollDie() {
        return random.nextInt(6) + 1;
    }

    // returns true if the player won
    private boolean playTurn(int playerNum) {
        int die1 = rollDie();
        int die2 = rollDie();
        int sum = die1 + die2;
        boolean sameDice = die1 == die2;

        System.out.println("Player " + playerNum + " rolls: " + die1 + " and " + die2);

        // Rule: If player rolls two 1's, they lose all their points
        if (die1 == 1 && die2 == 1) {
            if (playerNum == 1) {
                player1Score = 0;  // Player 1 loses all points
            } else {
                player2Score = 0;  // Player 2 loses all points
            }
            System.out.println("Player " + playerNum + " loses all points!");
        } else {
            if (playerNum == 1) {
                player1Score += sum;  // Add sum to Player 1's score
            } else {
                player2Score += sum;  // Add sum to Player 2's score
            }
        }

        // Check if player won by reaching 40 or more points
        if ((playerNum == 1 && player1Score >= 40 && sameDice) ||
            (playerNum == 2 && player2Score >= 40 && sameDice)) {
            System.out.println("Player " + playerNum + " wins with two matching dice after reaching 40 points!");
            return true;
        }

        // If dice are the same, player gets another turn
        if (sameDice) {
            System.out.println("Player " + playerNum + " gets another turn!");
            return playTurn(playerNum);  // Recursion for extra turn
        }

        return false;  // Player hasn't won yet
    }

    public void startGame() {
        while (true) {
            System.out.println("Player 1's turn:");
            if (playTurn(1)) break;

            System.out.println("Player 2's turn:");
            if (playTurn(2)) break;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();  // Create an instance of Game
        game.startGame();  // Start the game
    }
}
