import java.util.InputMismatchException;
import java.util.Scanner;
public class Hand {

    private static Deck deck = new Deck();
    private Card [] hand = new Card[12];
    private int handNumber = 0;

    public Hand() {
       deck.shuffle();
       getCard();
       getCard();
    }

    private void getCard() {
        hand[handNumber] = deck.getCard();
        handNumber ++;
    }



    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < hand.length; i ++) {
            if (hand[i] != null) {
                s += hand[i] + ", ";
            } else {
                break;
            }
        }
        return s;
    }

    public boolean getNewCard() {
        System.out.println("Want new card?\nYES (Y)\nNO (N)");
        boolean availavility = false;
        boolean answer = false;
        char response;
        while (!availavility) {
            Scanner input = new Scanner(System.in);
            try {
                response = input.next().toUpperCase().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("Eso no es una respuesta valida, imbecil");
                continue;
            }
            if (response != 'Y' && response != 'N') {
                System.out.println("Eso no es una respuesta valida, imbecil");
                continue;
            }
            availavility = true;
            if (response == 'Y') {
                getCard();
            } else {
                answer = true;
            }
        }
        return answer;
    }
    public int blackJackNumber() {
        boolean [] ases = new boolean[4];
        int asesNumbers = 0;
        int blackJack = 0;
        for (int i = 0; i < hand.length; i ++) {
            if (hand[i] != null) {
                switch (hand[i].getNumber()) {
                    case 11: case 12: case 13: blackJack += 10;
                    break;
                    case 1: ases[asesNumbers] = true;
                    asesNumbers ++;
                    break;
                    default: blackJack += hand[i].getNumber();
                }
            } else {
                break;
            }
        }
        int numberOfAses = 0;
        for (int i = 0; i < ases.length; i++) {
            if (ases[i]) {
                numberOfAses ++;
            }
        }
        if (numberOfAses > 0) {
            System.out.println(this);
        }
        for (int i = 0; i < numberOfAses; i ++) {
            int ace;
            System.out.println("You have 1 ace. Which value do you want?");
            Scanner input = new Scanner(System.in);
            ace = input.nextInt();
            if (ace != 1 && ace != 11) {
                ace = 1;
            }
            blackJack += ace;
        }
        return blackJack;
    }
}
