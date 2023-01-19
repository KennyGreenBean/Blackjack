import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack extends Game{
    public BlackJack(ArrayList<Card> deck, ArrayList<Human> players, Dealer dealer) {
        super(deck, players, dealer);
    }

    public void transferCards(Human player1, Human player2, Card card){
        for(int i = 0; i < player1.hand.size(); i++){
            if(player1.hand.get(i) == card){
                player1.hand.remove(i);
                break;
            }
        }
        player2.hand.add(card);
    }

    public void nextTurn(){
        if(turnCounter == players.size() - 1){
            turnCounter = 0;
        }
        else{
            turnCounter++;
        }
    }

    public void hit(Player player){
        Random rand = new Random();
        int val = rand.nextInt(deck.size());
        player.hand.add(deck.get(val));
        deck.remove(rand.nextInt(deck.size()));
    }

    public void getPlayerInput(int turnCounter){// hit or stand
        Scanner input = new Scanner(System.in);

        System.out.println(players.get(turnCounter) + "'s turn: Hit = 1, Stand = 2");
        int userInput = input.nextInt();

        if(userInput == 1){
            hit(players.get(turnCounter));
            nextTurn();
        }
        else{
            nextTurn();
        }
    }

    public int checkBust(Player player){ // 1 = bust, 2 = not bust, 3 = win
        int sum = 0;
        for(Card card:player.hand){
            sum += card.getValue();
        }

        if(sum > 21){
            return 1;
        }
        else if(sum < 21){
            return 2;
        }
        else{
            return 3;
        }
    }

    public void win(){
        for(Human player : players){
            player.money += player.betMoney * 2;
            player.betMoney = 0;
        }
    }

    public void endGame(){
        int highestHand = 0;
        for(Human player:players){
            if(player.handValue() > highestHand){
                highestHand = player.handValue();
            }
        }
        boolean finished = false;
        while(!finished) {
            hit(dealer);
            int checkbust = checkBust(dealer);

            if (checkbust == 1) {
                win();
                finished = true;
            }
            else if (checkbust == 2 && dealer.handValue() > highestHand) {
                for (Human player : players) {
                    player.money -= player.betMoney;
                    player.betMoney = 0;
                }
                finished = true;
            }
            else if (checkbust == 3) {
                for (Human player : players) {
                    player.money -= player.betMoney;
                    player.betMoney = 0;
                }
                finished = true;
            }
        }
    }
}
