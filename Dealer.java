public class Dealer extends Player{

    public Dealer(String playerName) {
        super(playerName);
    }

    public void showHand(boolean show, int value){
        if(show){//show 1 card
            System.out.println(hand.get(value).getValue() + " " + hand.get(value).getSuit());
        }
        else{//show entire hand
            printHand();
        }
    }
}
