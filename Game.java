import java.util.Random;
import java.util.Scanner;

public class Game {
    //The first argument is the playe's number, the second is his initial balance/money
    private Player player1 = new Player(1, 1000);  
    private Player player2 = new Player(2, 1000);  

    public void start() {
        while (true) {
            System.out.println("Player 1's turn:");
            if (player1.play()) break;  // Call play method on Player 1

            System.out.println("Player 2's turn:");
            if (player2.play()) break;  // Call play method on Player 2
        }
    }

    public static void main(String[] args) {
        Game app1 = new Game();  
        app1.start();  
    }
}
