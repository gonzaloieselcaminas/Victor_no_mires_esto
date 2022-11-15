public class Card {
    public static final int SPADES = 1;
    public static final int CLOVERS = 2;
    public static final int HEARTS = 3;
    public static final int DIAMONDS = 4;

    private int number;
    private int suit;

    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String s = "";
        if (number <= 10 && number > 1) {
            s += number;
        } else {
            switch (number) {
                case 1: s += "Ace";
                break;
                case 11: s += "Jack";
                    break;
                case 12: s += "Queen";
                    break;
                case 13: s += "King";
                    break;
            }
        }
        switch (suit) {
            case SPADES: s += " of spades";
                break;
            case CLOVERS: s += " of clovers";
                break;
            case HEARTS: s += " of hearts";
                break;
            case DIAMONDS: s += " of diamonds";
                break;
        }
        return s;
    }

    public int getNumber() {
        return number;
    }
}
