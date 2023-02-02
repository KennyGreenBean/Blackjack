import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        createBlackJack(input);


    }

    public static void createBlackJack(Scanner input){
        System.out.println("How many players would like to play?");
        int numberOfPlayers = input.nextInt();
        ArrayList<Human> players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("What is the name of the first player?");
            String name = input.nextLine();
            System.out.println("How much money do you have?");
            int money = input.nextInt();
            players.add(new Human(name, money));
        }

        System.out.println("How many decks will be used?");
        int decks = input.nextInt();
        Deck deck = new Deck(decks, false);
        deck.shuffle();

        BlackJack blackjackGame = new BlackJack(deck.deck, players, new Dealer("Dealer"));

        blackjackGame.Play(input);
    }

    public static void createCard(Scanner input){
        System.out.println("Please select the suit");
        System.out.println("1 = Diamonds, 2 = Hearts, 3 = Spades, 4 = Clubs");
        int userInput = input.nextInt();
        System.out.println("Now input what value it is, 2-10");
        int inputUser = input.nextInt();
        new Card(userInput, inputUser);
    }
}