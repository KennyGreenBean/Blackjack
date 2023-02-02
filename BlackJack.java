import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
        player.hand.add(deck.get(0));
        System.out.println("Recieved a " + deck.get(0).toString());
        deck.remove(0);
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

    private void addCards(){
        Random random = new Random();
        for (Human player : players) {
            int randomNumber = random.nextInt(0, deck.size());
            player.hand.add(deck.get(randomNumber));
            boolean cont = true;
            int newNumber = 0;
            while (cont) {
                newNumber = random.nextInt(0, deck.size());
                if (newNumber != randomNumber) {
                    cont = false;
                }
            }
            player.hand.add(deck.get(newNumber));
        }
        int randomNumber = random.nextInt(0, deck.size());
        dealer.hand.add(deck.get(randomNumber));
        boolean cont = true;
        int newNumber = 0;
        while(cont){
            newNumber = random.nextInt(0, deck.size());
            if(newNumber != randomNumber){
                cont = false;
            }
        }
        dealer.hand.add(deck.get(newNumber));
    }

    public void Play(Scanner input){
        boolean gameContinue = true;
        int totalLost = 0;
        while(gameContinue){

            for(turnCounter = 0; turnCounter < players.size(); turnCounter++){
                if(players.get(turnCounter).inOrOut == false){
                    continue;
                }
                System.out.println(players.get(turnCounter).playerName + "'s turn!");
                System.out.println("Would you like to see your hand? 1 = yes 2 = no");
                int userInput = input.nextInt();

                if(userInput == 1){
                    players.get(turnCounter).printHand();
                    System.out.println("Total Value: " + players.get(turnCounter).handValue());
                }
                System.out.println();
                System.out.println("Would you like to hit or stand? 1 = hit, 2 = stand");

                userInput = input.nextInt();
                if(userInput == 1){
                    hit(players.get(turnCounter));
                }
                else{
                    continue;
                }
                if(checkBust(players.get(turnCounter)) == 1){
                    players.get(turnCounter).money -= players.get(turnCounter).betMoney;
                    players.get(turnCounter).betMoney = 0;
                    players.get(turnCounter).inOrOut = false;
                    totalLost++;
                }
                else if(checkBust(players.get(turnCounter)) == 2){
                    continue;
                }
                else{
                    win();
                }
            }

            endGame();
        }
    }
}
