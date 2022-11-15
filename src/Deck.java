public class Deck {
    private Card[] cards;
    private int numCards;

    public Deck() {
        numCards = 52;
        cards = new Card[numCards];
        int i = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int number = 1; number <= 13; number++) {
                cards[i] = new Card(number, suit);
                i++;
            }
        }

    }

    public void shuffle() {
        for (int k = 0; k < 1000; k++) {
            int i = (int)(Math.random() * numCards);
            int j = (int)(Math.random() * numCards);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }


    public Card getCard() {
        numCards--;
        return cards[numCards];
    }

    @Override
    public String toString() {
        String s = "";
        for (int suit = 1; suit <= 4; suit++) {
            Boolean first = true;
            for (int i = 0; i < numCards; i++) {
                if (cards[i].getSuit() == suit) {
                    if (first) {
                        first = false;
                    } else {
                        s +=", ";
                    }
                    s += cards[i];
                }
            }
            s += "\n";
        }
        return s;
    }



}
