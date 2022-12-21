public class Card {
    private String suit;
    private final int value;

    public Card(int suit, int value){
        if(suit == 1){
            this.suit = "Diamonds";
        }
        else if(suit == 2){
            this.suit = "Hearts";
        }
        else if(suit == 3){
            this.suit = "Spades";
        }
        else if(suit == 4){
            this.suit = "Clubs";
        }
        else if(suit == 5){
            this.suit = "Joker";
        }
        this.value = value;
    }

    @Override
    public String toString(){
        return "This card is a " + value + "of" + suit;
    }

    public int getValue(){
        return value;
    }

    public String getSuit(){
        return suit;
    }

}
