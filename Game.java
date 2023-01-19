import java.util.ArrayList;

abstract class Game {
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Human> players = new ArrayList<>();
    Dealer dealer;
    ArrayList<Card> discardPile = new ArrayList<>();

    int turnCounter = 1;

    public Game(ArrayList<Card> deck, ArrayList<Human> players, Dealer dealer){
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
    }

    abstract public void transferCards(Human player1, Human player2, Card card);

    abstract public void nextTurn();
}
