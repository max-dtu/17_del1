import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BankAccount player1Account = new BankAccount("Bob", "43234522"); // owner, accountNumber
        BankAccount player2Account = new BankAccount("Alice", "43234523");

        double playBalanceOfPlayer1 = player1Account.withdraw(1000);
        double playBalanceOfPlayer2 = player2Account.withdraw(1000);

        Player player1 = new Player(1, playBalanceOfPlayer1);
        Player player2 = new Player(2, playBalanceOfPlayer2);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player 1's turn, press Enter to roll the dice...");
            scanner.nextLine();
            if (player1.playDie()) // Call play method on Player 1
                break; 

            System.out.println("Player 2's turn, press Enter to roll the dice...");
            scanner.nextLine();
            if (player2.playDie()) // Call play method on Player 2
                break; 
        }
    }



}
