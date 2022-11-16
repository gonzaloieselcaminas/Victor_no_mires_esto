public class    Main2 {
    public static void main(String[] args) {
        Player player1 = new Player("Victor");
        Player player2 = new Player("Calvicie");

        player1.playerTurn();
        player2.playerTurn();

        int player1Number = player1.getNumberValue();
        int player2Number = player2.getNumberValue();

        if (player1Number == 21 || player2Number == 21) {
            if (player1Number == 21 && player2Number != 21) {
                System.out.println(player1.getName() + " gana");
            } else if (player1Number == player2Number) {
                System.out.println("Empate");
            } else {
                System.out.println(player2.getName() + " gana");
            }
        } else if (player1Number > 21 || player2Number > 21) {
            if (player1Number > 21 && player2Number > 21) {
                System.out.println("Ambos pierden");
            } else if (player1Number > 21) {
                System.out.println(player2.getName() + " gana");
            } else {
                System.out.println(player1.getName() + " gana");
            }
        } else {
            if (player1Number > player2Number) {
                System.out.println(player1.getName() + " gana");
            } else if (player1Number == player2Number) {
                System.out.println("Empate");
            } else {
                System.out.println(player2.getName() + " gana");
            }
        }
    }
}
