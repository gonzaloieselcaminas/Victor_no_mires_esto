public class Main {
    public static void main(String[] args) {
        Hand myHand = new Hand();
        boolean gameOver = false;
        int blackjackNumber = 0;
        while (!gameOver) {
            System.out.println(myHand);
            gameOver = myHand.getNewCard();
            blackjackNumber = myHand.blackJackNumber();
            if (blackjackNumber >= 21) {
                gameOver = true;
            }
        }
        System.out.println(myHand);
        if (blackjackNumber > 21) {
            System.out.println("Sos malo");
        } else if (blackjackNumber == 21) {
            System.out.println("Debes de ser de Mcdonalds porque sos mcnifico");
        } else {
            System.out.println("Te has quedado a " + (21 - blackjackNumber) + " de ser un ganador");
        }
    }
}
