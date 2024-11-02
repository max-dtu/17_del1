import java.util.Scanner;

public class Main {

    private static BankAccount player1Account = new BankAccount("Bob", "43234522"); // owner, accountNumber
    private static BankAccount player2Account = new BankAccount("Alice", "43234523");
    private static double playBalanceOfPlayer1 = player1Account.withdraw(1000);
    private static double playBalanceOfPlayer2 = player2Account.withdraw(1000);

    // The first argument is the playe's number (id), the second is his balance
    private static Player player1 = new Player(1, playBalanceOfPlayer1);
    private static Player player2 = new Player(2, playBalanceOfPlayer2);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Player 1's turn, press Enter to roll the dice...");
            scanner.nextLine();
            if (player1.playDie())
                break; // Call play method on Player 1

            System.out.println("Player 2's turn, press Enter to roll the dice...");
            scanner.nextLine();
            if (player2.playDie())
                break; // Call play method on Player 2
        }
    }
}
