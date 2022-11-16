public class Player {
    private String name;
    private Hand playerHand;

    public Player(String name) {
        this.name = name;
        playerHand = new Hand();
    }

    public void playerTurn() {
        System.out.println("Turno de " + this.name);
        boolean endTurn = false;
        while (!endTurn) {
            System.out.println(playerHand);
            System.out.println("Llevas " + playerHand.blackJackNumber() + " puntos");
            endTurn = playerHand.getNewCard();
            if (playerHand.blackJackNumber() >= 21) {
                System.out.println(playerHand);
                endTurn = true;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberValue() {
        return playerHand.blackJackNumber();
    }
}
