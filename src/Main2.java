public class Main2 {
    public static void main(String[] args) {
        Hand player1 = new Hand();
        Hand player2 = new Hand();
        boolean gameOverPlayer1 = false;
        boolean gameOverPlayer2 = false;

        while (!gameOverPlayer1 && !gameOverPlayer2) {
            if (!gameOverPlayer1) {
                System.out.println("Turno de player 1");
                System.out.println(player1);
                gameOverPlayer1 = player1.getNewCard();
                if (player1.blackJackNumber() >= 21) {
                    gameOverPlayer1 = true;
                    System.out.println(player1);
                    System.out.println("Te has pasado de 21");
                }
            }
            if (!gameOverPlayer2) {
                System.out.println("Turno de player 2");
                System.out.println(player2);
                gameOverPlayer2 = player2.getNewCard();
                if (player2.blackJackNumber() >= 21) {
                    gameOverPlayer2 = true;
                    System.out.println(player2);
                    System.out.println("Te has pasado de 21");
                }
            }
        }
        // y aqui las condiciones de victoria que me dan mucho palo hacer
    }
}
