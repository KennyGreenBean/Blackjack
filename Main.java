import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello world!");

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