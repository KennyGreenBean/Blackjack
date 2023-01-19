import java.util.*;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>();

    String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void printHand(){
        int i;
        for(i = 0; i < hand.size() - 1; i++){
            System.out.print(hand.get(i).getValue() + " " + hand.get(i).getSuit() + ", ");
        }
        System.out.println(hand.get(i).getValue() + " " + hand.get(i).getSuit());
    }

    public void removeHand(){
        hand.clear();
    }

    public int handValue(){
        int value = 0;
        for(int i = 0; i < hand.size(); i++){
            value += hand.get(i).getValue();
        }
        return value;
    }
}
