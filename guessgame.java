import java.util.Random;
import java.util.Scanner;
//Class that runs the game
public class guessgame {

    public static void main(String[] args) {

    Scanner in = new Scanner(System.in); // scanner for user input
    Random bla = new Random();
    int number = bla.nextInt(100) + 1;

    // prompt to get user to input guess
    System.out.println("I am thinking of a number from 1 to 100. Can you guess it?");
    int guess = in.nextInt(); // variable that puts users input as an int and stores it in guess

    System.out.println("I was thinking of: " + number);
    }

    }