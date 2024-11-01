public class Main {
    
     private static Account player1Account = new Account();
     private static Account player2Account = new Account();
     private static int playBalanceOfPlayer1 = player1Account.withdraw(1000);
     private static int playBalanceOfPlayer2 = player2Account.withdraw(1000);

    //The first argument is the playe's number (id), the second is his balance
    private static Player player1 = new Player(1, playBalanceOfPlayer1);  
    private static Player player2 = new Player(2, playBalanceOfPlayer2);  
    
        public static void main(String[] args) {
            while (true) {
                System.out.println("Player 1's turn:");
                if (player1.play()) break;  // Call play method on Player 1

            System.out.println("Player 2's turn:");
            if (player2.play()) break;  // Call play method on Player 2
        }
    }
}
