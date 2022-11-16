public class Main {
    public static void main(String[] args) {
        Hand myHand = new Hand(); //instanciación de una nueva mano
        boolean gameOver = false; //booleano que controla el fin del juego

        while (!gameOver) {
            System.out.println(myHand); // Te muestra las cartas en tu mano
            gameOver = myHand.getNewCard(); // este metodo te pregunta si quieres otra y si dices que no, devuelve un booleano que pone el gameOver a true
            if (myHand.blackJackNumber() >= 21) { // si la suma de los numeros de la carta de tu mano dan + o = a 21 también se acaban el bucle
                gameOver = true;
            }
        }
        System.out.println(myHand); //A partir de aquí son las condiciones de si ganas o pierdes
        if (myHand.blackJackNumber() > 21) {
            System.out.println("Sos malo");
        } else if (myHand.blackJackNumber() == 21) {
            System.out.println("Debes de ser de Mcdonalds porque sos Mcnifico");
        } else {
            System.out.println("Te has quedado a " + (21 - myHand.blackJackNumber()) + " de ser un ganador");
        }
    }
}
