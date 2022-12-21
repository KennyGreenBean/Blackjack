import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private boolean jokers;
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(int decks, boolean jokers){
        this.jokers = jokers;
        for(int i = 0; i < decks; i++){
            createDeck();
        }
    }

    public void createDeck(){
        // diamonds
        deck.add(new Card(1, 1));
        deck.add(new Card(1, 2));
        deck.add(new Card(1, 3));
        deck.add(new Card(1, 4));
        deck.add(new Card(1, 5));
        deck.add(new Card(1, 6));
        deck.add(new Card(1, 7));
        deck.add(new Card(1, 8));
        deck.add(new Card(1, 9));
        deck.add(new Card(1, 10));
        deck.add(new Card(1, 11));
        deck.add(new Card(1, 12));
        deck.add(new Card(1, 13));

        // hearts
        deck.add(new Card(2, 1));
        deck.add(new Card(2, 2));
        deck.add(new Card(2, 3));
        deck.add(new Card(2, 4));
        deck.add(new Card(2, 5));
        deck.add(new Card(2, 6));
        deck.add(new Card(2, 7));
        deck.add(new Card(2, 8));
        deck.add(new Card(2, 9));
        deck.add(new Card(2, 10));
        deck.add(new Card(2, 11));
        deck.add(new Card(2, 12));
        deck.add(new Card(2, 13));

        // spaces
        deck.add(new Card(3, 1));
        deck.add(new Card(3, 2));
        deck.add(new Card(3, 3));
        deck.add(new Card(3, 4));
        deck.add(new Card(3, 5));
        deck.add(new Card(3, 6));
        deck.add(new Card(3, 7));
        deck.add(new Card(3, 8));
        deck.add(new Card(3, 9));
        deck.add(new Card(3, 10));
        deck.add(new Card(3, 11));
        deck.add(new Card(3, 12));
        deck.add(new Card(3, 13));

        // clubs
        deck.add(new Card(4, 1));
        deck.add(new Card(4, 2));
        deck.add(new Card(4, 3));
        deck.add(new Card(4, 4));
        deck.add(new Card(4, 5));
        deck.add(new Card(4, 6));
        deck.add(new Card(4, 7));
        deck.add(new Card(4, 8));
        deck.add(new Card(4, 9));
        deck.add(new Card(4, 10));
        deck.add(new Card(4, 11));
        deck.add(new Card(4, 12));
        deck.add(new Card(4, 13));

        if(jokers){
            deck.add(new Card(5, 0));
            deck.add(new Card(5, 0));
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void resetDeck(){
        deck.clear();
    }
}
