import java.util.Random;
import java.util.Scanner;

public class Game {
    
    player1Account = new Account();
    player2Account = new Account();
    private playBalanceOfPlayer1 = player1Account.withdraw(1000);
    private playBalanceOfPlayer2 = player2Account.withdraw(1000);

    //The first argument is the playe's number(id), the second is his balance
    private Player player1 = new Player(1, playBalance1);  
    private Player player2 = new Player(2, playBalanceOfPlayer2);  

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
